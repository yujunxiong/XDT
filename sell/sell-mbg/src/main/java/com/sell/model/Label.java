package com.sell.model;

/** 
* @author  作者 YJX 
* @date 创建时间： 2019年6月30日 下午6:32:18  
* @version 1.0  
* @return  
*/
public class Label {
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 套餐ID
	 */
	private Integer mealId;
	
	/**
	 * 标签类型 1推荐标签 2套餐标签
	 */
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
