package com.minghui.pay.pojo;

import java.util.List;
import com.minghui.pay.entity.${ClassName};

public class Cm${Entity}ResBean extends CmResBean {

	private List<${ClassName}> list;
	
	private ${ClassName} object;

	public List<${ClassName}> getList() {
		return list;
	}

	public void setList(List<${ClassName}> list) {
		this.list = list;
	}

	public ${ClassName} getObject() {
		return object;
	}

	public void setObject(${ClassName} object) {
		this.object = object;
	}
}
