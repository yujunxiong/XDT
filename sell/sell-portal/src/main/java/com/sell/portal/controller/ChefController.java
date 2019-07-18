package com.sell.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sell.portal.service.ChefService;

import io.swagger.annotations.ApiOperation;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月1日 下午8:12:29 
* @version 1.0  
* @return  
*/
@RestController
@RequestMapping("/chef")
public class ChefController {

	@Autowired
	private ChefService chefService;
	
	@ApiOperation("厨师列表获取")
	@RequestMapping("/list")
	public Object getsetMeal(String code, String date, @RequestParam(defaultValue="0")Integer rank, String keyWord, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="5")Integer pageSize){
		return chefService.getChefList(code, date, rank, keyWord, pageNum, pageSize);
	}
	
	@ApiOperation("厨师详情")
	@RequestMapping("/details")
	public Object getDetails(Integer chefId){
		return chefService.selectDetails(chefId);
	}
	
	@ApiOperation("厨师档期查询")
	@RequestMapping("/select/calendar")
	public Object getCalendar(Integer chefId){
		return chefService.selectCalendar(chefId);
	}
	
	
}
