package com.sell.model.vo;

import com.sell.model.Chef;
import com.sell.model.SetMeal;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月6日 下午6:43:52 
* @version 1.0  
* @return  
*/
public class ChefVo extends Chef{
	private static final long serialVersionUID = 1L;

	/**
	 * 所属公司名称
	 */
	private String companyName;
	
	/**
	 * 所属公司地址
	 */
	private String companyAddress;
	
	private SetMeal setMeal;

	public SetMeal getSetMeal() {
		return setMeal;
	}

	public void setSetMeal(SetMeal setMeal) {
		this.setMeal = setMeal;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public ChefVo() {
		super();
	}
	
}
