package com.sell.mapper;

import com.sell.model.ChefCalendar;

public interface ChefCalendarMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ChefCalendar record);

    int insertSelective(ChefCalendar record);

    ChefCalendar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChefCalendar record);

    int updateByPrimaryKey(ChefCalendar record);
}