package com.minghui.pay.common.notify.disruptor.base;

import com.lmax.disruptor.EventFactory;

/**
 * disrupter 事件工厂
* <p>Title: DisruoterEventFactory.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月19日  
* @version 1.0
 */
public class DisruptorEventFactory<T> implements EventFactory<DisruptorEvent<T>>{

	@Override
	public DisruptorEvent<T> newInstance() {
		return new DisruptorEvent<T>();
	}


}
