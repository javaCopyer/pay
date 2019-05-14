package com.minghui.pay.service;

import com.minghui.pay.pojo.Cm${Entity}ReqBean;
import com.minghui.pay.pojo.Cm${Entity}ResBean;
/**
 * ${varName}Service
 * @author yy
 *
 */
public interface I${Entity}Service {

	/**
	 * 添加
	 * @param req
	 * @return
	 * 	Cm${Entity}ReqBean req = new Cm${Entity}ReqBean();
		${ClassName} entity = new ${ClassName}();
		req.setEntity(entity);
		Cm${Entity}ResBean res = ${varName}Service.insert(req);
		int row = res.getRow();
	 */
	Cm${Entity}ResBean insert(Cm${Entity}ReqBean req);

	/**
	 * 删除
	 * @param req
	 * @return
	 * 	Cm${Entity}ReqBean req = new Cm${Entity}ReqBean();
		int id = 0;
		req.setId(id);
		Cm${Entity}ResBean res = ${varName}Service.deleteById(req);
		int row = res.getRow();
	 */
	Cm${Entity}ResBean deleteById(Cm${Entity}ReqBean req);

	/**
	 * 修改
	 * @param req
	 * @return
	 * 	Cm${Entity}ReqBean req = new Cm${Entity}ReqBean();
		${ClassName} entity = new ${ClassName}();
		req.setEntity(entity);
		Cm${Entity}ResBean res = ${varName}Service.updateByPrimaryKeySelective(req);
		Object row = res.getObject();
	 */
	Cm${Entity}ResBean updateByPrimaryKeySelective(Cm${Entity}ReqBean req);

	/** 
	 * 根据Id查询
	 * @param req
	 * @return
	 * 	Cm${Entity}ReqBean req = new Cm${Entity}ReqBean();
		// req.setId(1);
		Cm${Entity}ResBean res = ${varName}Service.selectById(req);
		Object row = res.getObject();
	 */
	Cm${Entity}ResBean selectById(Cm${Entity}ReqBean req);

	/**
	 * 条件查询 分页
	 * @param req
	 * @return
	 * 	Cm${Entity}ReqBean req = new Cm${Entity}ReqBean();
	 * 	req.setCurrentPage(1); 	// 当前页
		req.setPageLimit(1);	// 每页条数
		${ClassName} entity = new ${ClassName}();
		req.setEntity(entity);
		Cm${Entity}ResBean res = ${varName}Service.searchByPage(req);
		List<${ClassName}> list = (List<${ClassName}>) res.getList();
	 */
	Cm${Entity}ResBean searchByPage(Cm${Entity}ReqBean req);

	/**
	 * 条件查询
	 * @param req
	 * @return
	 * 	Cm${Entity}ReqBean req = new Cm${Entity}ReqBean();
		${ClassName} entity = new ${ClassName}();
		req.setEntity(entity);
		Cm${Entity}ResBean res = ${varName}Service.search(req);
		List<${ClassName}> list = (List<${ClassName}>) res.getList();
	 */
	Cm${Entity}ResBean search(Cm${Entity}ReqBean req);
}
