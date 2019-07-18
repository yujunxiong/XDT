package com.sell.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sell.model.Dish;
import com.sell.model.DishCategory;
import com.sell.model.SetMeal;

public interface DishMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);

	int addDish(Dish dish);

	int updateDish(Dish dish);

	int deleteDish(Integer id);

	List<Dish> listDish(@Param("companyId") String companyId,@Param("vendorSpuName") String vendorSpuName, @Param("categoryId") Integer categoryId);

	List<SetMeal> selDishAndSetMeal(Integer id);

	DishCategory getDishCategory(Integer id);

	Dish getDish(Integer id);
}