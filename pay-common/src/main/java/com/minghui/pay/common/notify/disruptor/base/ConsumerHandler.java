package com.minghui.pay.common.notify.disruptor.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.minghui.pay.common.notify.disruptor.handler.IDisruptorHandler;

/**
 * 消费者
* <p>Title: ConsumerHandler.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月19日  
* @version 1.0
 */
public class ConsumerHandler<T> implements EventHandler<DisruptorEvent<T>>, WorkHandler<DisruptorEvent<T>>{
	private Logger logger = LoggerFactory.getLogger(ConsumerHandler.class);
	private IDisruptorHandler<T> idisruptorHandler;
	private String consumerName;
	@Override
	public void onEvent(DisruptorEvent<T> event) throws Exception {
		logger.info("{} 消费消息开始>>>>>>>>>>>", consumerName);
		idisruptorHandler.execute(event.getData());
//		T data = event.getData();
//		Field[] fields = data.getClass().getDeclaredFields();
//		for (Field field : fields) {
//			boolean accessiable = field.isAccessible();
//			field.setAccessible(true);
//			System.out.println(field.getName() + " " + field.get(data));
//			field.setAccessible(accessiable);
//		}
		
		
		logger.info("{} 消费消息结束>>>>>>>>>>>", consumerName);
	}

	@Override
	public void onEvent(DisruptorEvent<T> event, long arg1, boolean arg2) throws Exception {
		idisruptorHandler.execute(event.getData());
	}

	public IDisruptorHandler<T> getIdisruptorHandler() {
		return idisruptorHandler;
	}

	public void setIdisruptorHandler(IDisruptorHandler<T> idisruptorHandler) {
		this.idisruptorHandler = idisruptorHandler;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	
	

}
