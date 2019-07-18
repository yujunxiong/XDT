package com.sell.model.response;

import java.util.List;

/**
* @author 作者:guyefeng
* @createDate 创建时间：2019年3月6日 下午5:10:41
*/

public class PageBean<E> {

	private List<E> list ;// 存放实体类集合                              
	private int  PageNum ;// 当前页
    private int  pageSize ;// 每页显示的条数
	private long  totalPage ;// 总页数
	private long  totalCount ;// 总条数
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public int getPageNum() {
		return PageNum;
	}
	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
