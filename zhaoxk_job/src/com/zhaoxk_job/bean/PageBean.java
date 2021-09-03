package com.zhaoxk_job.bean;

import java.util.List;
public class PageBean<T> {
	private int page=1;//当前页数
    private int totalCount;//总记录数
    private int totalPage;//总页数(总记录数/每页记录数)
    private int limit;//每页记录数
    private List<T> list;//包含商品的集合
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		System.out.println("page-bean:"+page+",totalPage:"+totalPage);
		
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

}
