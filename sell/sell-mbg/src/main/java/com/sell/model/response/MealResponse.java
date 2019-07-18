package com.sell.model.response;

import java.math.BigDecimal;
import java.util.List;

import com.sell.model.Label;

public class MealResponse {
	private Integer id; //套餐ID
	private String mealName; //套餐名称
	private String pic; //套餐名称
	private double score; //评分
	private BigDecimal price; //价格
	private Integer orderNum; //订购数量
	private Integer commentNum; //点评数量
	private String companyName; //公司名称
	private String address; //公司地址
	private Integer dinnerNum; //用餐人数
	private Integer recommend; //是否推荐 0否 1是
	private List<Labels> labels; //套餐标签
	
	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getDinnerNum() {
		return dinnerNum;
	}

	public void setDinnerNum(Integer dinnerNum) {
		this.dinnerNum = dinnerNum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Labels> getLabels() {
		return labels;
	}

	public void setLabels(List<Labels> labels) {
		this.labels = labels;
	}

	//套餐标签
	static class Labels{
		private Integer id;
		private String name;
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
		
	}
}
