package com.sell.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sell.model.DishCategory;

public interface DishCategoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DishCategory record);

    int insertSelective(DishCategory record);

    DishCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DishCategory record);

    int updateByPrimaryKey(DishCategory record);

	List<DishCategory> listCategory(@Param("dishCategoryName") String dishCategoryName);

	int updateCategory(DishCategory dishCategory);

	int addCategory(DishCategory dishCategory);
}