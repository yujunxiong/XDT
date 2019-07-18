package com.sell.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.portal.dto.LoginParameter;
import com.sell.portal.service.MemberLoginService;


/** 
* 微信小程序用户接口
* @author  作者 YJX 
* @date 创建时间：2019年6月28日 下午7:38:39 
* @version 1.0  
* @return  
*/
@RestController
@RequestMapping("/wx/member")
public class WxMaUserController {
	@Autowired
	private MemberLoginService memberLoginService;
	
	/**
     * 登录接口
     * @param appid
     * @param code
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(LoginParameter loginParameter) {
    	return memberLoginService.login(loginParameter);
    }
}
