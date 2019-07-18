package com.sell.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sell.admin.service.DishesService;
import com.sell.mapper.DishCategoryMapper;
import com.sell.mapper.DishMapper;
import com.sell.model.Dish;
import com.sell.model.DishCategory;
import com.sell.model.SetMeal;
import com.sell.model.response.PageBean;
import com.sell.util.CommonResult;

@Service
public class DishesServiceImpl implements DishesService {

	@Autowired
	private DishMapper dishMapper;
	@Autowired
	private DishCategoryMapper dishCategoryMapper;
	
	@Override
	public int addCategory(DishCategory dishCategory) {
		int num=0;
		try {
			num=dishCategoryMapper.addCategory(dishCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public int updateCategory(DishCategory dishCategory) {
		int num=0;
		try {
			num=dishCategoryMapper.updateCategory(dishCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public CommonResult listCategory(Integer pageSize, Integer pageNum,String dishCategoryName) {
		//分页查询
		PageHelper.startPage(pageNum, pageSize);
		List<DishCategory> DishCategorys= dishCategoryMapper.listCategory(dishCategoryName);
        PageInfo<DishCategory> list=new PageInfo<>(DishCategorys);
        PageBean<DishCategory> pageBean=new PageBean<>();
        pageBean.setList(list.getList());
        pageBean.setPageNum(list.getPageNum());
        pageBean.setPageSize(list.getPageSize());
        pageBean.setTotalCount(list.getTotal());
        pageBean.setTotalPage(list.getPages());
				 
		return new CommonResult().success(pageBean);
	}
	
	@Override
	public int addDish(Dish dish) {

		int num=0;
		try {
			num=dishMapper.addDish(dish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public int updateDish(Dish dish) {
		
		int num=0;
		try {
			num=dishMapper.updateDish(dish);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public CommonResult deleteDish(Integer id) {
		CommonResult commonResult=new CommonResult();
		int num=0;
		//查询该菜品是否和套餐关联
		List<SetMeal> SetMeals=dishMapper.selDishAndSetMeal(id);
		if(SetMeals.size()<=0) {
			num=dishMapper.deleteDish(id);
		}else {
			return commonResult.failed("该菜品和套餐关联，不能删除");
		}
		if(num==1) {
			commonResult.setCode(200);
			commonResult.setMessage("删除成功！");
			return commonResult;
		}
		
		commonResult.setCode(500);
		commonResult.setMessage("删除失败！");
		return commonResult;
	}
	@Override
	public CommonResult listDish(String companyId,Integer categoryId, String vendorSpuName,Integer pageSize, Integer pageNum) {
		//分页查询
		PageHelper.startPage(pageNum, pageSize);
		List<Dish> Dishs= dishMapper.listDish(companyId,vendorSpuName,categoryId);
        PageInfo<Dish> list=new PageInfo<>(Dishs);
        PageBean<Dish> pageBean=new PageBean<>();
        pageBean.setList(list.getList());
        pageBean.setPageNum(list.getPageNum());
        pageBean.setPageSize(list.getPageSize());
        pageBean.setTotalCount(list.getTotal());
        pageBean.setTotalPage(list.getPages());
				 
		return new CommonResult().success(pageBean);
	}
	
	@Override
	public CommonResult getDishCategory(Integer id) {
		CommonResult commonResult=new CommonResult();
		DishCategory  dishCategory=dishMapper.getDishCategory(id);
		commonResult.success(dishCategory);
		return commonResult;
	}
	@Override
	public Dish getDish(Integer id) {

		return dishMapper.getDish(id);
	}
	

}
