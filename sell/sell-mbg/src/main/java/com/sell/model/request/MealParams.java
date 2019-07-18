package com.sell.model.request;

import com.sell.model.response.Page;

public class MealParams extends Page{
	private String chefOrComapany; //厨师或者办酒公司
	private String townCode; //城镇码
	private Double startPrice; //起始价格
	private Double endPrice; //结束价格
	private Integer categoryId; //类型ID
	private Integer rank; //排序ID
	
	public String getChefOrComapany() {
		return chefOrComapany;
	}
	public void setChefOrComapany(String chefOrComapany) {
		this.chefOrComapany = chefOrComapany;
	}
	public String getTownCode() {
		return townCode;
	}
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}
	
	public Double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}
	public Double getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
}
