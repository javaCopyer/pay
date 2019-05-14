package com.minghui.pay.common.notify.disruptor.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkHandler;
/**
 * T: 基础消息实体泛型
 * E:disrupter event泛型
 * H 消费者泛型
* <p>Title: BaseDisrupterHelper.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月19日  
* @version 1.0
 */
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
/**
 * disruptor处理模板
* <p>Title: BaseDisruptorHelper.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月19日  
* @version 1.0
 */
public abstract class BaseDisruptorHelper<T> {
	/** disruptor对象 **/
	private Disruptor<DisruptorEvent<T>> disruptor;
	
	/** RingBuffer对象 **/
	private RingBuffer<DisruptorEvent<T>> ringBuffer;
	
	/** 初始化数据 **/
	private List<T> initList = new ArrayList<T>();

	
	
	/*** 如果要改变线程执行优先级，override此策略. YieldingWaitStrategy会提高响应并在闲时占用70%以上CPU，
     * 慎用SleepingWaitStrategy会降低响应更减少CPU占用，用于日志等场景.
	 * Disruptor策略 
	- BlockingWaitStrategy：默认等待策略。和BlockingQueue的实现很类似，通过使用锁和条件（Condition）进行线程同步和唤醒。此策略对于线程切换来说，最节约CPU资源，但在高并发场景下性能有限。 
	- SleepingWaitStrategy：CPU友好型策略。会在循环中不断等待数据。首先进行自旋等待，若不成功，则使用Thread.yield()让出CPU，并使用LockSupport.parkNanos(1)进行线程睡眠。所以，此策略数据处理可能会有较高的延迟，适合用于对延迟不敏感的场景。优点是对生产者线程影响小，典型应用场景是异步日志。 
	- YieldingWaitStrategy：低延时策略。消费者线程会不断循环监控RingBuffer的变化，在循环内部使用Thread.yield()让出CPU给其他线程。 
	- BusySpinWaitStrategy：死循环策略。消费者线程会尽最大可能监控缓冲区的变化，会占用所有CPU资源。
 **/
	protected abstract WaitStrategy getStrategy();
	
	/**RingBuffer长度 （2的倍数**/
	protected abstract int getQueueSize();
	
	/** 事件工厂  **/
	protected abstract EventFactory<DisruptorEvent<T>> eventFactory();
	
	/** 消费者 **/
	protected abstract WorkHandler<DisruptorEvent<T>>[] getconsumerHandler();
	
	
	protected abstract Executor getTaskExecutor();
	/**
	 * disruptor初始化 启动disrutor，发布初始化数据 
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月20日
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		disruptor = new Disruptor<DisruptorEvent<T>>(eventFactory(), getQueueSize(), getTaskExecutor(), ProducerType.SINGLE, getStrategy());
		disruptor.handleExceptionsWith(new DisruptorHandlerException());
		disruptor.handleEventsWithWorkerPool(getconsumerHandler());
	    ringBuffer = disruptor.start();
	    
	    
	    /** 初始化数据发布 **/
	    for (T data : initList) {
			ringBuffer.publishEvent(new EventTranslatorOneArg<DisruptorEvent<T>, T>() {
				@Override
				public void translateTo(DisruptorEvent<T> event, long sequence, T data) {
					event.setData(data);
				}
			}, data);
		}
	}
	
	/****
	 * 发布数据
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月20日
	 */
	public void publishEvent(T data) {
		 if (ringBuffer == null) {
	            initList.add(data);
	            return;
	    }
		ringBuffer.publishEvent(new EventTranslatorOneArg<DisruptorEvent<T>, T>() {
			@Override
			public void translateTo(DisruptorEvent<T> event, long sequence, T data) {
				event.setData(data);
			}
		}, data);
	}
	
	/**
	 * 关闭disruptor
	* <p>Title: </p>  
	* <p>Description: </p>  
	* @author sky  
	* @date 2019年3月20日
	 */
	public void shutdown() {
		disruptor.shutdown();
	}
}
