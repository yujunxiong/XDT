package com.sell.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author  作者 YJX 
* @date 创建时间： 2019年6月30日 下午3:37:14  
* @version 1.0  
* @return  
*/
public class PriceSection {
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 开始价格
	 */
	private BigDecimal startPrice;
	
	/**
	 * 结束价格
	 */
	private BigDecimal endPrice;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}

	public BigDecimal getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(BigDecimal endPrice) {
		this.endPrice = endPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
