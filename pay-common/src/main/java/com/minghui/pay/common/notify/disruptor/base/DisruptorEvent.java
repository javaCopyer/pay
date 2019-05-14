package com.minghui.pay.common.notify.disruptor.base;

/**
 * disruoter事件（消息）实体
* <p>Title: DisrupterEvent.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月19日  
* @version 1.0
 * @param <T>
 */
public class DisruptorEvent<T> {
	private T data;
	
	public DisruptorEvent() {};
	
	public DisruptorEvent(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
