package com.sell.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sell.model.MemberReceiveAddress;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月10日 下午8:20:21 
* @version 1.0  
* @return  
*/
public interface MemberReceiveAddressService {

	int add(HttpServletRequest request, MemberReceiveAddress address);

	int delete(HttpServletRequest request, Integer addressId);

	List<MemberReceiveAddress> list(HttpServletRequest request);

	int update(HttpServletRequest request, MemberReceiveAddress address);

	int choose(HttpServletRequest request, Integer addressId);
	
}
