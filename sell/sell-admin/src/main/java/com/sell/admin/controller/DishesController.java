package com.sell.admin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.admin.service.DishesService;
import com.sell.model.Dish;
import com.sell.model.DishCategory;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author guyefeng
 * 菜品管理
 */
@RestController
public class DishesController {
	
	@Autowired
	private DishesService  dishesService;
	
	@ApiOperation("新增菜品分类")
	@ResponseBody
    @RequestMapping(value = "/dishCategory/addCategory", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('dishCategory')")
    public Object addCategory(@RequestBody DishCategory dishCategory) {
		CommonResult commonResult=new CommonResult();
		dishCategory.setCreateTime(new Date());
		
		int num=dishesService.addCategory(dishCategory);
		if(num==1) {
			commonResult.setCode(200);
			commonResult.setMessage("新增成功！");
			return commonResult;
		}
		commonResult.setCode(500);
		commonResult.setMessage("新增失败！");
		return commonResult;
	}
	
	@ApiOperation("修改分类菜品分类/删除菜品分类")
	@ResponseBody
    @RequestMapping(value = "/dishCategory/updateCategory", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('dishCategory')")
    public Object updateCategory(@RequestBody DishCategory dishCategory) {
		CommonResult commonResult=new CommonResult();
		
		int num=dishesService.updateCategory(dishCategory);
		
		if(num==1) {
			commonResult.setCode(200);
			commonResult.setMessage("修改成功！");
			return commonResult;
		}
		commonResult.setCode(500);
		commonResult.setMessage("修改失败！");
		return commonResult;
	}
	
	@ApiOperation("查询菜品分类信息")
	@ResponseBody
    @RequestMapping(value = "/dishCategory/getDishCategory", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('dishCategory')")
    public Object getDishCategory( @RequestBody Integer id) {
		CommonResult commonResult=new CommonResult();
	  if(id==null) 
		  commonResult.failed("请选择菜单分类！");

		return dishesService.getDishCategory(id);
	}
	
	@ApiOperation("菜品列表分类")
	@ResponseBody
    @RequestMapping(value = "/dishCategory/listCategory", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('dishCategory')")
    public Object listCategory(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,String dishCategoryName) {
	
		return dishesService.listCategory(pageSize,pageNum,dishCategoryName);
	}
	
	
	//新增菜品
	@ApiOperation("新增菜品")
	@ResponseBody
    @RequestMapping(value = "/dish/addDish", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object addDish(@RequestBody Dish dish) {
		CommonResult commonResult=new CommonResult();
		dish.setCreateTime(new Date());
		
		int num=dishesService.addDish(dish);
		if(num==1) {
			commonResult.setCode(200);
			commonResult.setMessage("新增成功！");
			return commonResult;
		}
		commonResult.setCode(500);
		commonResult.setMessage("新增失败！");
		return commonResult;
	}
	
	
	@ApiOperation("修改菜品")
	@ResponseBody
    @RequestMapping(value = "/dish/updateDish", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object updateDish(@RequestBody Dish dish) {
		CommonResult commonResult=new CommonResult();
		
		int num=dishesService.updateDish(dish);
		if(num==1) {
			commonResult.setCode(200);
			commonResult.setMessage("修改成功！");
			return commonResult;
		}
		commonResult.setCode(500);
		commonResult.setMessage("修改失败！");
		return commonResult;
	}
	
	@ApiOperation("删除菜品")
	@ResponseBody
    @RequestMapping(value = "/dish/deleteDish/{id}", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object deleteDish(@PathVariable("id") Integer id) {
		CommonResult commonResult=new CommonResult();
		if(id==null)
			return commonResult.failed("请选择要删除菜品");
		
		return dishesService.deleteDish(id);
	}
	
	
	@ApiOperation("菜品列表")
	@ResponseBody
    @RequestMapping(value = "/dish/listDish", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object listDish(Integer categoryId,String vendorSpuName,@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		String companyId=null;
		return dishesService.listDish(companyId,categoryId,vendorSpuName,pageSize,pageNum);
	}
	

	//新增菜品
	@ApiOperation("查询菜品信息")
	@ResponseBody
    @RequestMapping(value = "/dish/getDish", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object getDish(Integer id) {
		CommonResult commonResult=new CommonResult();

		Dish dish=dishesService.getDish(id);
		commonResult.success(dish);
		return commonResult;
	}
	
	
	
}
