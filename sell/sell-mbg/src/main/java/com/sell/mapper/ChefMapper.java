package com.sell.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sell.model.Chef;
import com.sell.model.ChefCalendar;
import com.sell.model.request.Chefparams;
import com.sell.model.vo.ChefVo;

public interface ChefMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Chef record);

    int insertSelective(Chef record);

    Chef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chef record);

    int updateByPrimaryKey(Chef record);

	int add(Chefparams chefparams);

	List<ChefVo> getChefList(@Param("code")String code, @Param("rank")Integer rank, @Param("keyWord")String keyWord, @Param("dates")String[] dates);

	ChefVo selectChefInfo(Integer chefId);

	List<ChefCalendar> selectCalendar(@Param("date")Date date, @Param("chefId")Integer chefId);

	int update(Chefparams chefparams);

	Chef selSetMealbyChef(Integer id);

	List<Chef> list(@Param("token") String token,@Param("chefNameOrTel") String chefNameOrTel, @Param ("putaway") Integer putaway);

	Integer getCompanyId(String token);
}