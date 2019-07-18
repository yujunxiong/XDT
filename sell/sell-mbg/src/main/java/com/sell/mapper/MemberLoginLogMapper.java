package com.sell.mapper;

import com.sell.model.MemberLoginLog;

public interface MemberLoginLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MemberLoginLog record);

    int insertSelective(MemberLoginLog record);

    MemberLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberLoginLog record);

    int updateByPrimaryKey(MemberLoginLog record);

	void insertInfo(MemberLoginLog log);
}