package com.minghui.pay.common.exception;

/**
 * 全局异常
* <p>Title: SystemException.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月25日  
* @version 1.0
 */
public class SystemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6467308325642606190L;
	private String code;//状态码
    public SystemException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
