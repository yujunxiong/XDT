package com.sell.model.response;

import org.springframework.beans.factory.annotation.Value;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月16日 上午9:57:27 
* @version 1.0  
* @return  
*/
public class Page {
	private Integer pageNum;
	private Integer pageSize;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Page() {
		super();
	}
	
}
