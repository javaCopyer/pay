package com.minghui.pay.service;

import com.minghui.pay.pojo.CmPayAgentReqBean;
import com.minghui.pay.pojo.CmPayAgentResBean;
/**
 * payAgentService
 * @author yy
 *
 */
public interface IPayAgentService {

	/**
	 * 添加
	 * @param req
	 * @return
	 * 	CmPayAgentReqBean req = new CmPayAgentReqBean();
		PayAgent entity = new PayAgent();
		req.setEntity(entity);
		CmPayAgentResBean res = payAgentService.insert(req);
		int row = res.getRow();
	 */
	CmPayAgentResBean insert(CmPayAgentReqBean req);

	/**
	 * 删除
	 * @param req
	 * @return
	 * 	CmPayAgentReqBean req = new CmPayAgentReqBean();
		int id = 0;
		req.setId(id);
		CmPayAgentResBean res = payAgentService.deleteById(req);
		int row = res.getRow();
	 */
	CmPayAgentResBean deleteById(CmPayAgentReqBean req);

	/**
	 * 修改
	 * @param req
	 * @return
	 * 	CmPayAgentReqBean req = new CmPayAgentReqBean();
		PayAgent entity = new PayAgent();
		req.setEntity(entity);
		CmPayAgentResBean res = payAgentService.updateByPrimaryKeySelective(req);
		Object row = res.getObject();
	 */
	CmPayAgentResBean updateByPrimaryKeySelective(CmPayAgentReqBean req);

	/** 
	 * 根据Id查询
	 * @param req
	 * @return
	 * 	CmPayAgentReqBean req = new CmPayAgentReqBean();
		// req.setId(1);
		CmPayAgentResBean res = payAgentService.selectById(req);
		Object row = res.getObject();
	 */
	CmPayAgentResBean selectById(CmPayAgentReqBean req);

	/**
	 * 条件查询 分页
	 * @param req
	 * @return
	 * 	CmPayAgentReqBean req = new CmPayAgentReqBean();
	 * 	req.setCurrentPage(1); 	// 当前页
		req.setPageLimit(1);	// 每页条数
		PayAgent entity = new PayAgent();
		req.setEntity(entity);
		CmPayAgentResBean res = payAgentService.searchByPage(req);
		List<PayAgent> list = (List<PayAgent>) res.getList();
	 */
	CmPayAgentResBean searchByPage(CmPayAgentReqBean req);

	/**
	 * 条件查询
	 * @param req
	 * @return
	 * 	CmPayAgentReqBean req = new CmPayAgentReqBean();
		PayAgent entity = new PayAgent();
		req.setEntity(entity);
		CmPayAgentResBean res = payAgentService.search(req);
		List<PayAgent> list = (List<PayAgent>) res.getList();
	 */
	CmPayAgentResBean search(CmPayAgentReqBean req);
}
