package com.sell.model.response;

import java.util.List;

import com.sell.model.DishCategory;

/** 
* @author  作者 YJX 
* @date 创建时间： 2019年7月1日 下午11:30:55  
* @version 1.0  
* @return  
*/
public class MealDetails {
	private Integer id; //套餐ID
	private String mealName; //套餐名称
	private Integer hotDiahNum; //热菜数量
	private Integer coldDishNum; //冷菜数量
	private Integer dessertNum; //点心数量
	private Integer fruitNum; //水果数量
	private double anticipatedPrice; //预计价格
	List<DishCategory> dishCategory;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public Integer getHotDiahNum() {
		return hotDiahNum;
	}
	public void setHotDiahNum(Integer hotDiahNum) {
		this.hotDiahNum = hotDiahNum;
	}
	public Integer getColdDishNum() {
		return coldDishNum;
	}
	public void setColdDishNum(Integer coldDishNum) {
		this.coldDishNum = coldDishNum;
	}
	public Integer getDessertNum() {
		return dessertNum;
	}
	public void setDessertNum(Integer dessertNum) {
		this.dessertNum = dessertNum;
	}
	public Integer getFruitNum() {
		return fruitNum;
	}
	public void setFruitNum(Integer fruitNum) {
		this.fruitNum = fruitNum;
	}
	public double getAnticipatedPrice() {
		return anticipatedPrice;
	}
	public void setAnticipatedPrice(double anticipatedPrice) {
		this.anticipatedPrice = anticipatedPrice;
	}
	public List<DishCategory> getDishCategory() {
		return dishCategory;
	}
	public void setDishCategory(List<DishCategory> dishCategory) {
		this.dishCategory = dishCategory;
	}
	
}
