package com.minghui.pay.pojo;

/**
 * @title 通用服务_请求结果（响应）对象
 * 
 */
public class CmResBean {

	private String responseCode = "00"; // 服务处理结果代码 00 为正确
	private Exception exception; // 异常

	private String exceptionMsg;

	private String errMsg; // 错误信息_自定义

	private String errMsgDetail; // 错误信息_自定义

	private int row = 0;// 添加、删除、修改等影响数

	private Integer currentPage = 1; // 当前页
	private Integer pageLimit = 20; // 每页条数
	private Integer totalRows = 0;// 总记录数
	
	public CmResBean(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}
	
	public CmResBean() {
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public void setException(Exception exception) {
		this.exceptionMsg = exception.getMessage();
	}

	public String getErrMsgDetail() {
		return errMsgDetail;
	}

	public void setErrMsgDetail(String errMsgDetail) {
		this.errMsgDetail = errMsgDetail;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getExceptionMsg() {

		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {

		this.exceptionMsg = exceptionMsg;
	}

	public Exception getException() {

		return exception;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

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

	public Integer getTotalPages() {
		int mod = totalRows % pageLimit;
		int p = totalRows / pageLimit;
		if (mod == 0) {
			return p;
		} else {
			return p + 1;
		}
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

}
