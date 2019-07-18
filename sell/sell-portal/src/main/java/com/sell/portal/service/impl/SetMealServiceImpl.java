package com.sell.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.sell.mapper.SetMealMapper;
import com.sell.model.Dish;
import com.sell.model.request.MealParams;
import com.sell.model.response.MealResponse;
import com.sell.model.vo.SetMealVo;
import com.sell.portal.service.SetMealService;
import com.sell.util.CommonResult;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月1日 下午4:17:38 
* @version 1.0  
* @return  
*/
@Service
public class SetMealServiceImpl implements SetMealService {
	@Autowired
	private RedisTemplate<Object, Object>  objectRedisTemplate;
	StringRedisTemplate asa;

	@Autowired
	private SetMealMapper setMealMapper;
	
	//获取套餐列表
	@Override
	public CommonResult getsetMeal(MealParams params) {
		if(params.getPageNum()==null){
			params.setPageNum(0);
		}else{
			params.setPageNum((params.getPageNum()-1)*params.getPageSize());
		}
		if(params.getPageSize()==null){
			params.setPageSize(5);
		}
		List<MealResponse> meals = setMealMapper.selectList(params);
		return CommonResult.ok(meals);
	}

	//获取套餐详情
	@Override
	public CommonResult selectDetails(Integer mealId) {
		SetMealVo meal = setMealMapper.selectDetails(mealId);
		return CommonResult.ok(meal);
	}

	//替换菜品列表
	@Override
	public CommonResult getDishList(Integer companyId, Integer categoryId, Integer dishId) {
		List<Dish> dishs = setMealMapper.getDishList(companyId, categoryId, dishId);
		return CommonResult.ok(dishs);
	}

	//替换菜品
	@Override
	public CommonResult replaceDish(Integer chefId, Integer mealId, Integer replaceId, Integer cacheMealId, Integer dishId) {
		SetMealVo meal = null;
		if( cacheMealId==null ){ //没有套餐缓存信息
			meal = setMealMapper.selectDetails(mealId);
		}else{
			meal = (SetMealVo)objectRedisTemplate.opsForHash().get(chefId.toString(), mealId.toString());
		}
		Map<String, SetMealVo> map = new HashMap<>();
		map.put(mealId.toString(), meal);
		objectRedisTemplate.opsForHash().putAll(chefId.toString(), map);
		SetMealVo m = (SetMealVo)objectRedisTemplate.opsForHash().get(chefId.toString(), mealId.toString());
		return null;
	}

	@Override
	public CommonResult getRecommendMeal() {
		List<MealResponse> meals = setMealMapper.getRecommendMeal();
		return CommonResult.ok(meals);
	}

}
