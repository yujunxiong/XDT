package com.sell.mapper;

import com.sell.model.ChefDish;

public interface ChefDishMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ChefDish record);

    int insertSelective(ChefDish record);

    ChefDish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChefDish record);

    int updateByPrimaryKey(ChefDish record);
}