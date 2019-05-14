package com.minghui.pay.pojo;

public class CmReqBean {
	/**
	 * 当前页 默认第一页
	 */
	private Integer currentPage = new Integer(1);
	/**
	 * 每页条数 默认20条
	 */
	private Integer pageLimit = new Integer(20);
	/**
	 * 排序方式
	 */
	private String orderBy;
	
	/**
	 * 是否需要统计总条数
	 */
	private boolean rowsCount = true;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	public String getPageCondition() {
		int begin = getPageLimit() * (getCurrentPage() - 1);// 开始位置
		return " limit " + begin + "," + getPageLimit();
	}

	public Integer getBetinIndex() {
		int begin = getPageLimit() * (getCurrentPage() - 1);
		return begin;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(boolean rowsCount) {
		this.rowsCount = rowsCount;
	}
}
