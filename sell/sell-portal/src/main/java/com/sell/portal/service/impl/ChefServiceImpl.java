package com.sell.portal.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sell.mapper.ChefMapper;
import com.sell.model.Chef;
import com.sell.model.ChefCalendar;
import com.sell.model.vo.ChefVo;
import com.sell.portal.service.ChefService;
import com.sell.util.CommonResult;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月6日 下午5:56:07 
* @version 1.0  
* @return  
*/
@Service
public class ChefServiceImpl implements ChefService {
	@Autowired
	private ChefMapper chefMapper;

	//厨师列表获取
	@Override
	public CommonResult getChefList(String code, String date, Integer rank, String keyWord, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		String[] dates = null;
		if(date!=null){
			dates = date.split(",");
		}
		List<ChefVo> list = chefMapper.getChefList(code, rank, keyWord, dates);
		return CommonResult.ok(list);
	}

	//厨师详情 
	@Override
	public CommonResult selectDetails(Integer chefId) {
		ChefVo chef= chefMapper.selectChefInfo(chefId);
		return CommonResult.ok(chef);
	}

	//厨师档期
	@Override
	public CommonResult selectCalendar(Integer chefId) {
		Date date = new Date();
		List<ChefCalendar> calendar =  chefMapper.selectCalendar(date, chefId);
		return CommonResult.ok(calendar);
	}

}
