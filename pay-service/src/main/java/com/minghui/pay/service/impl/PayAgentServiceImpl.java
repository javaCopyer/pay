package com.minghui.pay.service.impl;

import java.util.List;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.minghui.pay.dao.PayAgentMapper;
import com.minghui.pay.entity.PayAgent;
import com.minghui.pay.entity.PayAgentExample.Criteria;
import com.minghui.pay.entity.PayAgentExample;
import com.minghui.pay.service.IPayAgentService;
import com.minghui.pay.pojo.CmPayAgentReqBean;
import com.minghui.pay.pojo.CmPayAgentResBean;
import com.minghui.pay.constant.ServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("payAgentService")
public class PayAgentServiceImpl implements IPayAgentService {
	private static final Logger log = LoggerFactory.getLogger(PayAgentServiceImpl.class);
	@Autowired
	PayAgentMapper payAgentDAO;

	public CmPayAgentResBean insert(CmPayAgentReqBean req) {
		CmPayAgentResBean res = new CmPayAgentResBean();
		try {
			int rows = payAgentDAO.insert(req.getEntity());
			res.setRow(rows);
		} catch (Exception ex) {
			log.error(".insert", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}
		return res;
	}

	public CmPayAgentResBean deleteById(CmPayAgentReqBean req) {
		CmPayAgentResBean res = new CmPayAgentResBean();
		try {
			Integer id = req.getId();
			int row = payAgentDAO.deleteByPrimaryKey(id);
			if (row < 0) {
				res.setErrMsg("delete error.");
				res.setErrMsgDetail("删除不成功.");
				res.setResponseCode(ServiceConstants.LOG_RES_CODE_RESULT_NULL);
				return res;
			}
			res.setRow(row);// 删除结果
		} catch (Exception ex) {
			log.error(".deleteById", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}
		return res;
	}

	public CmPayAgentResBean updateByPrimaryKeySelective(CmPayAgentReqBean req) {
		CmPayAgentResBean res = new CmPayAgentResBean();
		try {
			int row = payAgentDAO.updateByPrimaryKeySelective(req.getEntity());
			if (row < 0) {
				res.setErrMsg("updateByPrimaryKeySelective error.");
				res.setErrMsgDetail("更新不成功.");
				res.setResponseCode(ServiceConstants.LOG_RES_CODE_RESULT_NULL);
				return res;
			}
			res.setRow(row);
		} catch (Exception ex) {
			log.error(".updateByPrimaryKeySelective", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}
		return res;
	}

	public CmPayAgentResBean selectById(CmPayAgentReqBean req) {
		CmPayAgentResBean res = new CmPayAgentResBean();
		try {
			/** 1.取得关键值 **/
			Integer id = req.getId();

			/** 2.查询数据 **/
			PayAgent payAgent = payAgentDAO.selectByPrimaryKey(id);

			/** 4.查询结果非空判断 **/
			if (payAgent == null) {
				res.setErrMsg("selectById is null.");
				res.setErrMsgDetail("没有记录.");
				res.setResponseCode(ServiceConstants.LOG_RES_CODE_RESULT_NULL);
				return res;
			}

			/** $封装响应值$ **/
			res.setObject(payAgent);
		} catch (Exception ex) {
			log.error(".selectById", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}

		return res;
	}

	public CmPayAgentResBean searchByPage(CmPayAgentReqBean req) {
		CmPayAgentResBean res = new CmPayAgentResBean();
		try {
			/** 查询条件 **/
			PayAgentExample example = new PayAgentExample();
			if (req.getEntity() != null) {
				/** 封装查询参数 **/
				PayAgent entity = req.getEntity();
				Criteria criteria = example.createCriteria();
			}
			
			/** 总条数 **/
			if (req.isRowsCount()) {
				res.setTotalRows(payAgentDAO.countByExample(example));// 总条数(前端分页用)
			}
			
			/** 排序 分页 **/
			StringBuffer sb = new StringBuffer();
			if (StringUtils.isNotBlank(req.getOrderBy())) {
				sb.append(req.getOrderBy());
			} else {
				// sb.append(" id desc ");
			}
			sb.append(req.getPageCondition());// 分页
			example.setOrderByClause(sb.toString());
			
			/** 查询数据 **/
			List<PayAgent> list = payAgentDAO.selectByExample(example);

			/** 查询结果非空判断 **/
			if (CollectionUtils.isEmpty(list)) {
				res.setErrMsg("search is null.");
				res.setErrMsgDetail("没有记录.");
				res.setResponseCode(ServiceConstants.LOG_RES_CODE_RESULT_NULL);
				return res;
			}

			/** $封装响应值$ **/
			res.setList(list);
			res.setObject(list.get(0));
		} catch (Exception ex) {
			log.error(".search", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}

		return res;
	}
	
	public CmPayAgentResBean search(CmPayAgentReqBean req) {
		CmPayAgentResBean res = new CmPayAgentResBean();
		try {
			/** 查询条件 **/
			PayAgentExample example = new PayAgentExample();
			if (req.getEntity() != null) {
				/** 封装查询参数 **/
				PayAgent entity = req.getEntity();
				Criteria criteria = example.createCriteria();
			}
			
			/** 排序 **/
			StringBuffer sb = new StringBuffer();
			// sb.append(" id desc ");// 排序
			// example.setOrderByClause(sb.toString());
			
			/** 查询数据 **/
			List<PayAgent> list = payAgentDAO.selectByExample(example);

			/** 查询结果非空判断 **/
			if (CollectionUtils.isEmpty(list)) {
				res.setErrMsg("search is null.");
				res.setErrMsgDetail("没有记录.");
				res.setResponseCode(ServiceConstants.LOG_RES_CODE_RESULT_NULL);
				return res;
			}

			/** $封装响应值$ **/
			res.setList(list);
			res.setObject(list.get(0));
		} catch (Exception ex) {
			log.error(".search", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}

		return res;
	}
}
