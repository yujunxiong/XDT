package com.sell.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sell.model.Dish;
import com.sell.model.MealCategory;
import com.sell.model.SetMeal;
import com.sell.model.request.MealParams;
import com.sell.model.response.MealResponse;
import com.sell.model.vo.SetMealVo;

public interface SetMealMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SetMeal record);

    int insertSelective(SetMeal record);

    SetMeal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SetMeal record);

    int updateByPrimaryKey(SetMeal record);

	List<SetMeal> select();

	List<MealResponse> selectList(MealParams params);

	SetMealVo selectDetails(Integer mealId);

	List<Dish> getDishList(@Param("companyId")Integer companyId, @Param("categoryId")Integer categoryId, @Param("dishId")Integer dishId);

	List<Dish> getDishs(@Param("dishIds") List<Integer> dishIds);

	void add(SetMeal setMeal);

	void relationDish(@Param("dishIds") List<Integer> dishIds, @Param("id") Integer id);

	void update(SetMeal setMeal);

	List<Integer> getRelationSetmealAndDish(Integer id);

	void delSetDish(@Param("oldDishIds") List<Integer> oldDishIds,@Param("id") Integer id);

	void delete(Integer id);

	List<SetMealVo> list(@Param("companyId") Integer companyId,@Param("chefId") Integer chefId, @Param("categoryId") Integer categoryId,  @Param("status") Integer status, @Param("name") String name);

	SetMeal listSetMealInfo(Integer id);

	List<MealCategory> listSetMealCategory();

	List<MealResponse> getRecommendMeal();


}