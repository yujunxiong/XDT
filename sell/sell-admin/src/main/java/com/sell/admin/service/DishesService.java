package com.sell.admin.service;

import com.sell.model.Dish;
import com.sell.model.DishCategory;
import com.sell.model.SetMeal;
import com.sell.util.CommonResult;

public interface DishesService {

	int addCategory(DishCategory dishCategory);

	int updateCategory(DishCategory dishCategory);

	CommonResult listCategory(Integer pageSize, Integer pageNum, String dishCategoryName);

	int addDish(Dish dish);

	int updateDish(Dish dish);

	CommonResult deleteDish(Integer id);

	CommonResult listDish(String companyId, Integer categoryId, String vendorSpuName, Integer pageSize, Integer pageNum);

	CommonResult getDishCategory(Integer id);

	Dish getDish(Integer id);


}
