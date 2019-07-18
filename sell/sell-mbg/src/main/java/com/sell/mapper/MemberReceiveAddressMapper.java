package com.sell.mapper;

import com.sell.model.MemberReceiveAddress;
import com.sell.model.MemberReceiveAddressExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberReceiveAddressMapper {
	List<MemberReceiveAddress> selectByExample(MemberReceiveAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberReceiveAddress record);

    int insertSelective(MemberReceiveAddress record);

    MemberReceiveAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberReceiveAddress record);

    int updateByPrimaryKey(MemberReceiveAddress record);

	int deleteAddress(Integer addressId);

	List<MemberReceiveAddress> selectAdderssList(Integer id);

	int choose(Integer addressId);

	void cancelChoose(Integer id);
	
	int updateByExampleSelective(@Param("record") MemberReceiveAddress record, @Param("example") MemberReceiveAddressExample example);
}