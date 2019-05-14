package com.minghui.pay.pojo;

import com.minghui.pay.entity.PayAgent;

public class CmPayAgentReqBean extends CmReqBean {

	private PayAgent entity;
	private Integer id;

	public PayAgent getEntity() {
		return entity;
	}

	public void setEntity(PayAgent entity) {
		this.entity = entity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
