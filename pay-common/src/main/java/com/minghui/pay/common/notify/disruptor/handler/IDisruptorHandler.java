package com.minghui.pay.common.notify.disruptor.handler;

public interface IDisruptorHandler<T> {
	public void execute(T data);
}
