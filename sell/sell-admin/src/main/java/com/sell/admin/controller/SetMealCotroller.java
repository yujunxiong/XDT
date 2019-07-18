package com.sell.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.admin.service.DishesService;
import com.sell.admin.service.SetMealService;
import com.sell.model.DishCategory;
import com.sell.model.Dish;
import com.sell.model.SetMeal;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author guyefeng
 * 套餐管理
 */
@RestController
@RequestMapping("/setMeal")
public class SetMealCotroller {

	@Autowired
	private SetMealService setMealService;
	
	@ApiOperation("新增套餐")
	@ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object add(@RequestBody SetMeal setMeal) {
		
		setMeal.setCreateTime(new Date());
		//冷菜，热菜，水果，点心
		int coldDishNum=0,hotDishNum=0,fruitNum=0,dessertNum=0;
		List<Integer> dishIds = setMeal.getDishIds();
		System.out.println(dishIds);
		//查询菜品
		List<Dish> dishs=setMealService.getDishs(setMeal.getDishIds());
		for (Dish dish : dishs) {
			if(dish.getCategoryId()==1)
				hotDishNum++;
			if(dish.getCategoryId()==2)
				coldDishNum++;
			if(dish.getCategoryId()==3)
				dessertNum++;
			if(dish.getCategoryId()==4)
				fruitNum++;
		}
		setMeal.setColdDishNum(coldDishNum);
		setMeal.setHotDishNum(hotDishNum);
		setMeal.setFruitNum(fruitNum);
		setMeal.setDessertNum(dessertNum);	
		
		return setMealService.add(setMeal);
	}
	
	@ApiOperation("更新套餐")
	@ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object update(@RequestBody SetMeal setMeal) {
		
		//冷菜，热菜，水果，点心
		int coldDishNum=0,hotDishNum=0,fruitNum=0,dessertNum=0;
	    
		//查询菜品
		List<Dish> dishs=setMealService.getDishs(setMeal.getDishIds());
		for (Dish dish : dishs) {
			if(dish.getCategoryId()==1)
				hotDishNum++;
			if(dish.getCategoryId()==2)
				coldDishNum++;
			if(dish.getCategoryId()==3)
				dessertNum++;
			if(dish.getCategoryId()==4)
				fruitNum++;
		}
		setMeal.setColdDishNum(coldDishNum);
		setMeal.setHotDishNum(hotDishNum);
		setMeal.setFruitNum(fruitNum);
		setMeal.setDessertNum(dessertNum);	
		
		return setMealService.update(setMeal);
	}
	
	@ApiOperation("删除套餐")
	@ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object delete(@PathVariable("id") Integer id) {
		CommonResult commonResult=new CommonResult();
		if(id==null) {
			commonResult.setCode(500);
			commonResult.setMessage("请先选择套餐！");
			return commonResult;
		}

		return setMealService.delete(id);
			
	}
	
	@ApiOperation("套餐列表")
	@ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object list(Integer companyId ,Integer chefId,Integer categoryId,Integer status,String name ,@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,

            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

		return setMealService.list(companyId,chefId,categoryId,status,name,pageSize,pageNum);
			
	}
	

	@ApiOperation("套餐详情")
	@ResponseBody
    @RequestMapping(value = "/listSetMealInfo/{id}", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object listSetMealInfo(@PathVariable("id") Integer id) {
		CommonResult commonResult=new CommonResult();
		if(id==null) 
			return commonResult.failed("请选择套餐！");
		
		return setMealService.listSetMealInfo(id);
			
	}
	
	@ApiOperation("套餐分类列表")
	@ResponseBody
    @RequestMapping(value = "/listSetMealCategory", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object listSetMealCategory() {
		
		return setMealService.listSetMealCategory();
			
	}
}
