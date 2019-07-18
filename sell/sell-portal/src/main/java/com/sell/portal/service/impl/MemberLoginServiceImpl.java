package com.sell.portal.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sell.mapper.MemberLoginLogMapper;
import com.sell.mapper.MemberMapper;
import com.sell.model.Member;
import com.sell.model.MemberLoginLog;
import com.sell.portal.config.WxMaConfiguration;
import com.sell.portal.controller.WxMaUserController;
import com.sell.portal.dto.LoginParameter;
import com.sell.portal.jwt.JwtTokenUtil;
import com.sell.portal.service.MemberLoginService;
import com.sell.util.AccessToken;
import com.sell.util.CommonResult;
import com.sell.util.ReturnCode;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginServiceImpl implements MemberLoginService {
	private final Logger logger = LoggerFactory.getLogger(WxMaUserController.class);
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${wx.appid}")
    private String appid;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberLoginLogMapper memberLoginLogMapper;
	
	@Override
	public CommonResult login(LoginParameter loginParameter) {
		if (StringUtils.isBlank(loginParameter.getCode())) {
            this.logger.error("empty jscode");
            return new CommonResult().failed("登录失败！");
        }
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = null;
			try {
				session = wxService.getUserService().getSessionInfo(loginParameter.getCode());
				this.logger.info(session.getSessionKey());
	            this.logger.info(session.getOpenid());
			} catch (Exception e2) {
				e2.printStackTrace();
				logger.error("微信授权失败+{}", e2);
				return new CommonResult().failed(ReturnCode.LOGIN_WX_ACCREDIT_FAILED);
			}
            //处理业务逻辑代码
            String openid =/* session.getOpenid();*/"123456";
            Member member = memberMapper.selectMemberByOpenId(openid);
            long umsMeberId = 0;
            Date date = new Date();
            if(member==null){//第一次进入小程序将新增用户数据
            	Member me = new Member();
            	me.setOpenId(openid);
            	me.setDeviceId(loginParameter.getDeviceId());
            	me.setCreateTime(date);
            	me.setPhone(loginParameter.getTel());
            	me.setNickname(loginParameter.getNickName());
            	me.setIcon(loginParameter.getHeadPic());
            	me.setGender(loginParameter.getGender());
            	me.setSourceType(loginParameter.getSourceType());
            	int id = memberMapper.insertByOpenId(me);
            	umsMeberId = me.getId();
            }else{
            	umsMeberId = member.getId();
            }
            //记录登录日志
            try {
				//Map<String, String> map = new AddressUtils().getAddresses("ip="+loginParameter.getIp(), "utf-8");
				String province = null;
				String city = null;
				/*if(map!=null && map.size()>0){
					province = map.get("region");
					city = map.get("city");
				}*/
				MemberLoginLog log = new MemberLoginLog(umsMeberId,date,loginParameter.getIp(),city,loginParameter.getLoginType(),province
						,loginParameter.getDeviceModel(),loginParameter.getSourceType(),loginParameter.getAppVersion(),loginParameter.getOs(),loginParameter.getDeviceId(), loginParameter.getDeviceVersion());
				memberLoginLogMapper.insertInfo(log);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error("登录日志记录失败+{}", e1);
			}
            //使用JWT生成token
            String token =null;
            try {
                token = jwtTokenUtil.generateToken(openid);
            } catch (Exception e) {
            	logger.warn("jwtToken生成失败:{}", e.getMessage());
            }
            Map<String, Object> map = new HashMap<>();
            AccessToken accessToekn = new AccessToken(token,tokenHead);
            map.put("accessToekn", accessToekn);
            //map.put("session", session);
            return new CommonResult().success(map);
        } catch (Exception e) {
            this.logger.error("登录失败！", e);
            return new CommonResult().failed("登录失败！");
        }
	}

}
