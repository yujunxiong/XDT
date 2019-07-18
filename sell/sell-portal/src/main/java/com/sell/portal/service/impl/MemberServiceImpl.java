package com.sell.portal.service.impl;

import io.jsonwebtoken.JwtException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.sell.mapper.MemberExample;
import com.sell.mapper.MemberMapper;
import com.sell.model.Member;
import com.sell.portal.jwt.JwtTokenUtil;
import com.sell.portal.service.MemberService;
import com.sell.portal.service.RedisService;
import com.sell.util.CommonResult;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

/**
 * 会员管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${authCode.expire.seconds}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
	private JwtTokenUtil jwtTokenUtil;
    @Override
    public Member getByUsername(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public Member getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }


    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return new CommonResult().success("获取验证码成功",sb.toString());
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        MemberExample example = new MemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<Member> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return new CommonResult().failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return new CommonResult().failed("验证码错误");
        }
        Member umsMember = memberList.get(0);
        //umsMember.setPassword(passwordEncoder.encodePassword(password,null));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        return new CommonResult().success("密码修改成功",null);
    }

    @Override
    public Member getCurrentMember(HttpServletRequest request) {
    	String header = request.getHeader(this.tokenHeader);
    	if(StringUtils.isEmpty(header)){
    		return null;
    	}
	    String authToken = header.substring(this.tokenHead.length());// The part after "Bearer "
        String openid = null;
        Member umsMember = null;
		try {
			openid = jwtTokenUtil.getUserNameFromToken(authToken);
			umsMember = memberMapper.selectMemberByOpenId(openid);
		} catch (JwtException e) {
			return null;
		}
		//UmsMember umsMember = memberMapper.selectMemberByOpenId("oqEJH41hcp8b178-N6VeC1rR7eWg");
		return umsMember;
    }

    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return authCode.equals(realAuthCode);
    }

}
