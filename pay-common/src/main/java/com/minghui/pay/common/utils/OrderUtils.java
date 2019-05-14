package com.minghui.pay.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成订单号码
* <p>Title: OrderUtils.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月27日  
* @version 1.0
 */
public class OrderUtils {
	public static final SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
	public static final SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddss");
	/**
	 * 生成18位订单号码
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月27日
	 */
	public static String generatorOrderNo(Date date) {
		String nextId = String.valueOf(snowflakeIdWorker.nextId());
		nextId = nextId.substring(nextId.length() - 8);
		return sd.format(date) + nextId;
	}
	
	public static String generatorOrderNo() {
		return generatorOrderNo(new Date());
	}
	
}
