package com.minghui.pay.common.pojo;

import com.minghui.pay.common.enums.ResEnum;

public class ResBean<T> {
	private String errorCode;

	private String msg;

	private T datas;

	@SuppressWarnings("unchecked")
	public ResBean() {
		this.errorCode = ResEnum.SUCCESS.getCode();
		this.msg = ResEnum.SUCCESS.getMsg();
		this.datas = (T) new Object();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}
}
