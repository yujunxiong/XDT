package com.sell.mapper;

import com.sell.model.TurnkeyCompany;

public interface TurnkeyCompanyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TurnkeyCompany record);

    int insertSelective(TurnkeyCompany record);

    TurnkeyCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TurnkeyCompany record);

    int updateByPrimaryKey(TurnkeyCompany record);
}