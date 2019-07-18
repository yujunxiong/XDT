package com.sell.admin.service;

import java.util.List;

import com.sell.model.Dish;
import com.sell.model.SetMeal;
import com.sell.util.CommonResult;

public interface SetMealService {

	List<Dish> getDishs(List<Integer> dishIds);

	CommonResult add(SetMeal setMeal);

	CommonResult update(SetMeal setMeal);

	CommonResult delete(Integer id);

	CommonResult list(Integer companyId, Integer chefId, Integer categoryId, Integer status, String name, Integer pageSize, Integer pageNum);

	CommonResult listSetMealInfo(Integer id);

	CommonResult listSetMealCategory();

}
