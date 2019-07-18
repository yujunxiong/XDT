package com.sell.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.admin.service.ChefService;
import com.sell.model.request.Chefparams;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author guyefeng
 * 厨师管理
 */
@RestController
@RequestMapping("/chef")
public class ChefController {
	@Autowired
	private ChefService chefService;

	//新增厨师
	@ApiOperation("新增厨师")
	@ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object add(@RequestBody Chefparams chefparams,HttpServletRequest request) {
		String token = request.getHeader("Authorization").split(" ")[1];
		CommonResult commonResult=new CommonResult();
		int count=chefService.add(chefparams);
		if(count==1) {
			commonResult.setCode(200);
			commonResult.setMessage("新增成功！");
			return commonResult;
		}
			
		return commonResult.failed("新增失败！");
    }
	
	@ApiOperation("更新厨师")
	@ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object update(@RequestBody Chefparams chefparams,HttpServletRequest request) {
		String token = request.getHeader("Authorization").split(" ")[1];
		int num=0;
		CommonResult commonResult=new CommonResult();
		num=chefService.update(chefparams);
		if(num==1) {
			commonResult.setCode(200);
			commonResult.setMessage("更新成功！");
			return commonResult;
		}
		return commonResult.failed("更新失败！");
    }
	
	@ApiOperation("删除厨师")
	@ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object del(Integer id,HttpServletRequest request) {
	  String token = request.getHeader("Authorization").split(" ")[1];
	   if(id==null || id==0) {
		   CommonResult commonResult=new CommonResult();
		   commonResult.setCode(500);
		   commonResult.setMessage("请选择厨师");
		   return commonResult;
	   }
		return chefService.del(id);
	}

	@ApiOperation("厨师列表")
	@ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object list(String chefNameOrTel,Integer putaway,
    		@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum ,HttpServletRequest request) {
		
		String token = request.getHeader("Authorization").split(" ")[1];
        
		return chefService.list(token,chefNameOrTel,putaway,pageNum,pageSize);
	}
	
}
