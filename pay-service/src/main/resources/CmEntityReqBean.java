package com.minghui.pay.pojo;

import com.minghui.pay.entity.${ClassName};

public class Cm${Entity}ReqBean extends CmReqBean {

	private ${ClassName} entity;
	private Integer id;

	public ${ClassName} getEntity() {
		return entity;
	}

	public void setEntity(${ClassName} entity) {
		this.entity = entity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
