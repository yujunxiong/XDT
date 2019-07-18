package com.sell.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sell.model.Member;

public interface MemberMapper {
	List<Member> selectByExample(MemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

	Member selectMemberByOpenId(String openid);

	int insertByOpenId(@Param("openid")String openid, @Param("deviceid")String deviceid, @Param("token")String token, @Param("date")Date date);

	int insertByOpenId(Member me);

}