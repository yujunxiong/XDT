package com.sell.portal.service;

import com.sell.model.request.MealParams;
import com.sell.util.CommonResult;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月1日 下午4:15:42 
* @version 1.0  
* @return  
*/
public interface SetMealService {
	CommonResult getsetMeal(MealParams params);

	CommonResult selectDetails(Integer mealId);

	CommonResult getDishList(Integer companyId, Integer categoryId, Integer dishId);

	CommonResult replaceDish(Integer mealId, Integer replaceId, Integer cacheMealId, Integer dishId, Integer dishId2);

	CommonResult getRecommendMeal();
}
