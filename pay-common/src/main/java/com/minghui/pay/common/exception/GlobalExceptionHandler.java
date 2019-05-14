package com.minghui.pay.common.exception;

import org.springframework.validation.BindException;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.minghui.pay.common.enums.ResEnum;
import com.minghui.pay.common.pojo.ResBean;

/**
 * 全局异常处理器
* <p>Title: GlobalExceptionHandler.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月25日  
* @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 参数校验异常处理
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月25日
	 */
	@ExceptionHandler(BindException.class)
	public ResBean<Object> handleBindException(BindException ex) {
		FieldError fieldError = ex.getFieldError();
		StringBuilder sb = new StringBuilder();
		sb.append(fieldError.getDefaultMessage());
		ResBean<Object> errorResult = new ResBean<Object>();
		errorResult.setErrorCode(ResEnum.FAILURE.getCode());
		errorResult.setMsg(sb.toString());
		return errorResult;
	}
	
	/**
	 * 系统自定义异常处理
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月25日
	 */
	@ExceptionHandler(SystemException.class)
	public ResBean<Object> handleBindException(SystemException ex) {
		ResBean<Object> errorResult = new ResBean<Object>();
		errorResult.setErrorCode(ResEnum.FAILURE.getCode());
		errorResult.setMsg(ex.getMessage());
		return errorResult;
	}
	
	/**
	 * 其他exception处理
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月25日
	 */
	@ExceptionHandler(Exception.class)
	public ResBean<Object> handleOtherException(Exception ex) {
		ResBean<Object> errorResult = new ResBean<Object>();
		errorResult.setErrorCode(ResEnum.FAILURE.getCode());
		errorResult.setMsg(ResEnum.FAILURE.getMsg());
		return errorResult;
	}
}
