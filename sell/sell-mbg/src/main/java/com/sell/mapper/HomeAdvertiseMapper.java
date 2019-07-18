package com.sell.mapper;

import java.util.List;

import com.sell.model.HomeAdvertise;

public interface HomeAdvertiseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(HomeAdvertise record);

    int insertSelective(HomeAdvertise record);

    HomeAdvertise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomeAdvertise record);

    int updateByPrimaryKey(HomeAdvertise record);

	List<HomeAdvertise> getAdvertise();
}