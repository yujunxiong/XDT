package com.sell.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sell.model.request.MealParams;
import com.sell.portal.service.SetMealService;

import io.swagger.annotations.ApiOperation;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月1日 下午7:14:28 
* @version 1.0  
* @return  
*/
@RestController
@RequestMapping("/setMeal")
public class SetMealController {
	
	@Autowired
	private SetMealService setMealService;
	
	@ApiOperation("套餐列表获取")
	@RequestMapping("/list")
	public Object getsetMeal(MealParams params){
		return setMealService.getsetMeal(params);
	}
	
	@ApiOperation("推荐套餐列表获取")
	@RequestMapping("/list/recommend")
	public Object getRecommendMeal(){
		return setMealService.getRecommendMeal();
	}
	
	@ApiOperation("套餐详情")
	@RequestMapping("/details")
	public Object getDetails(Integer mealId){
		return setMealService.selectDetails(mealId);
	}
	
	@ApiOperation("替换菜品列表")
	@RequestMapping("/dish/list")
	public Object getDishList(Integer companyId, Integer categoryId,Integer dishId){
		return setMealService.getDishList(companyId, categoryId,dishId);
	}
	
	/**
	 * 替换菜品
	 * @param chefId 厨师Id
	 * @param mealId 套餐Id
	 * @param cacheMealId 缓存套餐Id
	 * @param dishId 被菜品Id
	 * @param replaceId 替换菜品Id
	 * @return
	 */
	@ApiOperation("替换菜品")
	@RequestMapping("/replace/dish")
	public Object replaceDish(Integer chefId, Integer mealId, Integer replaceId, Integer cacheMealId,Integer dishId){
		return setMealService.replaceDish(chefId, mealId, replaceId, cacheMealId, dishId);
	}
	
}
