package com.sell.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sell.admin.service.ChefService;
import com.sell.mapper.ChefMapper;
import com.sell.model.Chef;
import com.sell.model.request.Chefparams;
import com.sell.model.response.PageBean;
import com.sell.util.CommonResult;

@Service
public class ChefServiceImpl implements ChefService {
	@Autowired
	private ChefMapper chefMapper;

	@Override
	public int add(Chefparams chefparams) {
		int num=0;
		//根据token查询商户id
		//Integer companyId=chefMapper.getCompanyId(chefparams.getToken());
		//if(companyId==null || companyId<=0)
			//return num;
		
		//chefparams.setCompanyId(companyId);
		try {
			num=chefMapper.add(chefparams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int update(Chefparams chefparams) {
		int num=0;
		try {
			num=chefMapper.update(chefparams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public CommonResult del(Integer id) {
		CommonResult commonResult=new CommonResult();
		
		//查询该厨师是否关联有套餐或者是否有档期
		Chef chef=chefMapper.selSetMealbyChef(id);
		
		//删除厨师
		return null;
	}

	@Override
	public CommonResult list(String token,String chefNameOrTel, Integer putaway, int pageNum, int pageSize) {
		//分页查询
		PageHelper.startPage(pageNum, pageSize);
		List<Chef> chefs= chefMapper.list(token,chefNameOrTel,putaway);
        PageInfo<Chef> list=new PageInfo<>(chefs);
        PageBean<Chef> pageBean=new PageBean<>();
        pageBean.setList(list.getList());
        pageBean.setPageNum(list.getPageNum());
        pageBean.setPageSize(list.getPageSize());
        pageBean.setTotalCount(list.getTotal());
        pageBean.setTotalPage(list.getPages());
		 
		return new CommonResult().success(pageBean);
	}

}
