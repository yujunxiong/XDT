package com.sell.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.admin.service.impl.LoginServiceImpl;
import com.sell.admin.dto.UmsAdminLoginParam;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class LoginController {

	@Autowired 
	private LoginServiceImpl loginService;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;

	    @ApiOperation(value = "登录以后返回token")
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    @ResponseBody
	    public Object login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
	        String token = loginService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
	        if (token == null) {
	            return new CommonResult().failed("用户名或密码错误");
	        }
	        Map<String, String> tokenMap = new HashMap<>();
	        tokenMap.put("token", token);
	        tokenMap.put("tokenHead", tokenHead);
	        return new CommonResult().success(tokenMap);
	    }
}
