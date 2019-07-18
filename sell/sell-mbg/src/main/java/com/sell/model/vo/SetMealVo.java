package com.sell.model.vo;

import java.io.Serializable;
import java.util.List;

import com.sell.model.Dish;
import com.sell.model.DishCategory;
import com.sell.model.SetMeal;

/** 
* @author  作者 YJX 
* @date 创建时间： 2019年7月2日 下午10:13:29  
* @version 1.0  
* @return  
*/
public class SetMealVo extends SetMeal {
	private static final long serialVersionUID = 1L;

	private String chefName; //厨师名称
	
	private String companyName; //公司地址
	
	private Double chefScore; //评分
	
	private String chefPic; //厨师头像
	
	private String categoryName; //套餐分类名称
	
	private List<DishCategory> dishCategory;
	
	private List<Dish> dish;
	
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Dish> getDish() {
		return dish;
	}

	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}

	public Double getChefScore() {
		return chefScore;
	}

	public void setChefScore(Double chefScore) {
		this.chefScore = chefScore;
	}

	public String getChefPic() {
		return chefPic;
	}

	public void setChefPic(String chefPic) {
		this.chefPic = chefPic;
	}

	public String getChefName() {
		return chefName;
	}

	public void setChefName(String chefName) {
		this.chefName = chefName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<DishCategory> getDishCategory() {
		return dishCategory;
	}

	public void setDishCategory(List<DishCategory> dishCategory) {
		this.dishCategory = dishCategory;
	}
}
