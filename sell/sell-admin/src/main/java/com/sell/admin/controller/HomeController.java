package com.sell.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.admin.service.ChefService;
import com.sell.model.request.Chefparams;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author guyefeng
 * 
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private ChefService chefService;

	//新增厨师
	@ApiOperation("新增厨师")
	@ResponseBody
    @RequestMapping(value = "/menuList", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('public')")
    public Object add(@RequestBody Chefparams chefparams) {
		CommonResult commonResult=new CommonResult();
	
		int count=chefService.add(chefparams);
		if(count==1) {
			commonResult.setCode(200);
			commonResult.setMessage("新增成功！");
			return commonResult;
		}
			
		
		return commonResult.failed("新增失败！");
    }
}
