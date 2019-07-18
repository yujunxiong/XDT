package com.sell.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sell.model.request.MealParams;
import com.sell.portal.service.HomeService;
import io.swagger.annotations.ApiOperation;

/** 
* 首页
* @author  作者 YJX 
* @date 创建时间：2019年6月30日 上午11:11:39 
* @version 1.0  
* @return  
*/
@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private HomeService homeService;

	@ApiOperation("首页轮播图展示")
    @RequestMapping(value = "/advertise", method = RequestMethod.GET)
    public Object advertise() {
		return homeService.getAdvertise();
    }
	
	@ApiOperation("城镇列表获取")
	@RequestMapping("/towns")
	public Object getTownInfo(Double lo, Double la){
		return homeService.getCodeByCityCode(lo, la);
	}
	
	@ApiOperation("价格区间获取")
	@RequestMapping("/priceSection")
	public Object getPriceSection(){
		return homeService.getPriceSection();
	}
	
	@ApiOperation("套餐分类获取")
	@RequestMapping("/meal/classify")
	public Object getMealClassify(){
		return homeService.getMealClassify();
	}
	
}
