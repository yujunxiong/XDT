package com.sell.portal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sell.mapper.MemberReceiveAddressMapper;
import com.sell.model.Member;
import com.sell.model.MemberReceiveAddress;
import com.sell.model.MemberReceiveAddressExample;
import com.sell.portal.service.MemberReceiveAddressService;
import com.sell.portal.service.MemberService;
import com.sell.portal.util.HttpSenderUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户地址管理Service实现类
 * Created by macro on 2018/8/28.
 */
@Service
public class MemberReceiveAddressServiceImpl implements MemberReceiveAddressService {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberReceiveAddressMapper addressMapper;
    @Value("${gaode.key}")
   	private String appKey;
    @Override
    @Transactional
    public int add(HttpServletRequest request,MemberReceiveAddress address) {
        Member currentMember = memberService.getCurrentMember(request);
        if(address.getDefaultStatus()==1){ //将新增地址设置为默认地址,取消其它默认地址
        	List<MemberReceiveAddress> adderssList = addressMapper.selectAdderssList(currentMember.getId());
            if(!CollectionUtils.isEmpty(adderssList)){
            	for (MemberReceiveAddress umsMemberReceiveAddress : adderssList) {
        			if(umsMemberReceiveAddress.getDefaultStatus()==1){
        				addressMapper.cancelChoose(umsMemberReceiveAddress.getId());
        			}
        		}
            }
        }
        String json = null;
        String code = null ;
		try {
			json = HttpSenderUtils.sendGet("https://restapi.amap.com/v3/geocode/regeo","key="+appKey+"&location="+address.getLo()+","+address.getLa());
			code = JSONObject.parseObject(json).getJSONObject("regeocode").getJSONObject("addressComponent").get("adcode").toString();
			System.out.println("调用高德的返回的json数据："+code);
			System.out.println("获取到的城市code"+code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		address.setCode(code);
        address.setMemberId(currentMember.getId());
        return addressMapper.insert(address);
    }

    @Override
    public int delete(HttpServletRequest request,Integer addressId) {
    	return addressMapper.deleteAddress(addressId);
    }

    @Override
    public int update(HttpServletRequest request,MemberReceiveAddress address) {
        address.setId(null);
        String json = null;
        String code = null ;
		try {
			json = HttpSenderUtils.sendGet("https://restapi.amap.com/v3/geocode/regeo","key="+appKey+"&location="+address.getLo()+","+address.getLa());
			code = JSONObject.parseObject(json).getJSONObject("regeocode").getJSONObject("addressComponent").get("adcode").toString();
			System.out.println("调用高德的返回的json数据："+code);
			System.out.println("获取到的城市code"+code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		address.setCode(code);
        Member currentMember = memberService.getCurrentMember(request);
        if(address.getDefaultStatus()==1){ //将新增地址设置为默认地址,取消其它默认地址
        	List<MemberReceiveAddress> adderssList = addressMapper.selectAdderssList(currentMember.getId());
            if(!CollectionUtils.isEmpty(adderssList)){
            	for (MemberReceiveAddress umsMemberReceiveAddress : adderssList) {
        			if(umsMemberReceiveAddress.getDefaultStatus()==1){
        				addressMapper.cancelChoose(umsMemberReceiveAddress.getId());
        			}
        		}
            }
        }
        MemberReceiveAddressExample example = new MemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(address.getId());
        return addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<MemberReceiveAddress> list(HttpServletRequest request) {
    	Member currentMember = memberService.getCurrentMember(request);
    	return addressMapper.selectAdderssList(currentMember.getId());
    }

    //选择收货地址（设置为默认地址）
	@Override
	public int choose(HttpServletRequest request, Integer addressId) {
		List<MemberReceiveAddress> memberReceiveAddressList = list(request);
		for (MemberReceiveAddress umsMemberReceiveAddress : memberReceiveAddressList) {
			if(umsMemberReceiveAddress.getDefaultStatus()==1){
				addressMapper.cancelChoose(umsMemberReceiveAddress.getId());
			}
		}
		return addressMapper.choose(addressId);
	}
}
