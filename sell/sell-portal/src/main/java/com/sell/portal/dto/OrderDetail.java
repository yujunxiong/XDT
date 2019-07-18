package com.sell.portal.dto;

import java.util.Date;

import com.sell.model.vo.SetMealVo;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月10日 下午2:14:55 
* @version 1.0  
* @return  
*/
public class OrderDetail {
    private Integer addressId; //用户地址ID
	private Date startTime; //服务开始时间
	private Date endTime; //服务结束时间
	private Integer chefId; //厨师ID
	private SetMealVo setMeal;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getChefId() {
		return chefId;
	}
	public void setChefId(Integer chefId) {
		this.chefId = chefId;
	}
	public SetMealVo getSetMeal() {
		return setMeal;
	}
	public void setSetMeal(SetMealVo setMeal) {
		this.setMeal = setMeal;
	}
	
}
