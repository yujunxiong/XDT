package com.sell.admin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sell.admin.service.SetMealService;
import com.sell.mapper.SetMealMapper;
import com.sell.model.Dish;
import com.sell.model.DishCategory;
import com.sell.model.SetMeal;
import com.sell.model.response.PageBean;
import com.sell.model.vo.SetMealVo;
import com.sell.util.CommonResult;

@Service
public class SetMealServiceImpl implements SetMealService {
	@Autowired
	private SetMealMapper setMealMapper;

	@Override
	public List<Dish> getDishs(List<Integer> dishIds) {

		return setMealMapper.getDishs(dishIds);
	}
	
	@Override
	@Transactional
	public CommonResult add(SetMeal setMeal) {
		CommonResult commonResult=new CommonResult();
		int num=0;
		try {
			//新增套餐
			setMealMapper.add(setMeal);
			//关联菜品
			setMealMapper.relationDish(setMeal.getDishIds(),setMeal.getId());
			num=1;
		} catch (Exception e) {
			new RuntimeException();
			e.printStackTrace();
		}
		
	    if(num==1) {
	    	commonResult.setCode(200);
	    	commonResult.setMessage("新增成功！");
	    	return commonResult;
	    }else {
	    	commonResult.setCode(500);
	    	commonResult.setMessage("新增失败！");
	    	return commonResult;
	    }
	    	
		
	}

	@Override
	@Transactional
	public CommonResult update(SetMeal setMeal) {
		CommonResult commonResult=new CommonResult();
		int num=0;
		try {
		//更新套餐信息
		 setMealMapper.update(setMeal);
		//查询选中菜品中是否有已经关联的菜品进行剔除
		 List<Integer> dishIds =setMealMapper.getRelationSetmealAndDish(setMeal.getId());
		 
			if(dishIds!=null || dishIds.size()>0) {
				 //删除关联关系（已有）
				 List<Integer> oldDishIds = dishIds.stream().filter(item -> !setMeal.getDishIds().contains(item)).collect(Collectors.toList());
				 setMealMapper.delSetDish(oldDishIds,setMeal.getId());
				 //新增关联关系
				 List<Integer> newDishIds = setMeal.getDishIds().stream().filter(item -> !dishIds.contains(item)).collect(Collectors.toList());
				 setMealMapper.relationDish(newDishIds,setMeal.getId());
			 }else {
				 //新增关联关系
				 setMealMapper.relationDish(setMeal.getDishIds(),setMeal.getId());
			 }
			num=1;
		} catch (Exception e) {
			new RuntimeException();
			e.printStackTrace();
		}
		
		 if(num==1) {
		    	commonResult.setCode(200);
		    	commonResult.setMessage("更新成功！");
		    	return commonResult;
		    }else {
		    	commonResult.setCode(500);
		    	commonResult.setMessage("更新失败！");
		    	return commonResult;
		   }

	}

	@Override
	@Transactional
	public CommonResult delete(Integer id) {
		CommonResult commonResult=new CommonResult();
		int num=0;
		//查询套餐关联的菜品
		List<Integer> dishIds = setMealMapper.getRelationSetmealAndDish(id);
		try {
			//删除套餐信息
			setMealMapper.delete(id);
			//删除套餐和菜品关联信息
			setMealMapper.delSetDish(dishIds, id);
			num=1;
		} catch (Exception e) {
			new RuntimeException();
			e.printStackTrace();
		}
		
		 if(num==1) {
		    	commonResult.setCode(200);
		    	commonResult.setMessage("删除成功！");
		    	return commonResult;
		    }else {
		    	commonResult.setCode(500);
		    	commonResult.setMessage("删除失败！");
		    	return commonResult;
		   }
	}

	@Override
	public CommonResult list(Integer companyId,Integer chefId, Integer categoryId, Integer status,String name, Integer pageSize, Integer pageNum) {
		
		//分页查询
		PageHelper.startPage(pageNum, pageSize);
		List<SetMealVo> setMeals= setMealMapper.list(companyId,chefId,categoryId,status,name);
        PageInfo<SetMealVo> list=new PageInfo<>(setMeals);
        PageBean<SetMealVo> pageBean=new PageBean<>();
        pageBean.setList(list.getList());
        pageBean.setPageNum(list.getPageNum());
        pageBean.setPageSize(list.getPageSize());
        pageBean.setTotalCount(list.getTotal());
        pageBean.setTotalPage(list.getPages());
				 
		return new CommonResult().success(pageBean);
	}

	@Override
	public CommonResult listSetMealInfo(Integer id) {
		CommonResult commonResult=new CommonResult();
		
		return commonResult.success(setMealMapper.listSetMealInfo(id));
	}

	@Override
	public CommonResult listSetMealCategory() {
		CommonResult commonResult=new CommonResult();
		return commonResult.success(setMealMapper.listSetMealCategory());
	}

}
