package com.minghui.pay.pojo;

import java.util.List;
import com.minghui.pay.entity.PayAgent;

public class CmPayAgentResBean extends CmResBean {

	private List<PayAgent> list;
	
	private PayAgent object;

	public List<PayAgent> getList() {
		return list;
	}

	public void setList(List<PayAgent> list) {
		this.list = list;
	}

	public PayAgent getObject() {
		return object;
	}

	public void setObject(PayAgent object) {
		this.object = object;
	}
}
