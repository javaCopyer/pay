package com.minghui.pay.service.impl;

import java.util.List;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.minghui.pay.dao.${ClassName}Mapper;
import com.minghui.pay.entity.${ClassName};
import com.minghui.pay.entity.${ClassName}Example.Criteria;
import com.minghui.pay.entity.${ClassName}Example;
import com.minghui.pay.service.I${Entity}Service;
import com.minghui.pay.pojo.Cm${Entity}ReqBean;
import com.minghui.pay.pojo.Cm${Entity}ResBean;
import com.minghui.pay.constant.ServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("${varName}Service")
public class ${Entity}ServiceImpl implements I${Entity}Service {
	private static final Logger log = LoggerFactory.getLogger(${Entity}ServiceImpl.class);
	@Autowired
	${ClassName}Mapper ${varName}DAO;

	public Cm${Entity}ResBean insert(Cm${Entity}ReqBean req) {
		Cm${Entity}ResBean res = new Cm${Entity}ResBean();
		try {
			int rows = ${varName}DAO.insert(req.getEntity());
			res.setRow(rows);
		} catch (Exception ex) {
			log.error(".insert", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}
		return res;
	}

	public Cm${Entity}ResBean deleteById(Cm${Entity}ReqBean req) {
		Cm${Entity}ResBean res = new Cm${Entity}ResBean();
		try {
			Integer id = req.getId();
			int row = ${varName}DAO.deleteByPrimaryKey(id);
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

	public Cm${Entity}ResBean updateByPrimaryKeySelective(Cm${Entity}ReqBean req) {
		Cm${Entity}ResBean res = new Cm${Entity}ResBean();
		try {
			int row = ${varName}DAO.updateByPrimaryKeySelective(req.getEntity());
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

	public Cm${Entity}ResBean selectById(Cm${Entity}ReqBean req) {
		Cm${Entity}ResBean res = new Cm${Entity}ResBean();
		try {
			/** 1.取得关键值 **/
			Integer id = req.getId();

			/** 2.查询数据 **/
			${ClassName} ${varName} = ${varName}DAO.selectByPrimaryKey(id);

			/** 4.查询结果非空判断 **/
			if (${varName} == null) {
				res.setErrMsg("selectById is null.");
				res.setErrMsgDetail("没有记录.");
				res.setResponseCode(ServiceConstants.LOG_RES_CODE_RESULT_NULL);
				return res;
			}

			/** $封装响应值$ **/
			res.setObject(${varName});
		} catch (Exception ex) {
			log.error(".selectById", ex);
			res.setException(ex);
			res.setErrMsg(ex.getMessage());
			res.setResponseCode(ServiceConstants.LOG_RES_CODE_EXCEPTION);
		}

		return res;
	}

	public Cm${Entity}ResBean searchByPage(Cm${Entity}ReqBean req) {
		Cm${Entity}ResBean res = new Cm${Entity}ResBean();
		try {
			/** 查询条件 **/
			${ClassName}Example example = new ${ClassName}Example();
			if (req.getEntity() != null) {
				/** 封装查询参数 **/
				${ClassName} entity = req.getEntity();
				Criteria criteria = example.createCriteria();
			}
			
			/** 总条数 **/
			if (req.isRowsCount()) {
				res.setTotalRows(${varName}DAO.countByExample(example));// 总条数(前端分页用)
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
			List<${ClassName}> list = ${varName}DAO.selectByExample(example);

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
	
	public Cm${Entity}ResBean search(Cm${Entity}ReqBean req) {
		Cm${Entity}ResBean res = new Cm${Entity}ResBean();
		try {
			/** 查询条件 **/
			${ClassName}Example example = new ${ClassName}Example();
			if (req.getEntity() != null) {
				/** 封装查询参数 **/
				${ClassName} entity = req.getEntity();
				Criteria criteria = example.createCriteria();
			}
			
			/** 排序 **/
			StringBuffer sb = new StringBuffer();
			// sb.append(" id desc ");// 排序
			// example.setOrderByClause(sb.toString());
			
			/** 查询数据 **/
			List<${ClassName}> list = ${varName}DAO.selectByExample(example);

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
