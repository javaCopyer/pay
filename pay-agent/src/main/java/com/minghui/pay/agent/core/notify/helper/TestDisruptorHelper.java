package com.minghui.pay.agent.core.notify.helper;

import java.util.List;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkHandler;
import com.minghui.pay.agent.core.notify.data.TestData;
import com.minghui.pay.common.notify.disruptor.base.BaseDisruptorHelper;
import com.minghui.pay.common.notify.disruptor.base.ConsumerHandler;
import com.minghui.pay.common.notify.disruptor.base.DisruptorEvent;
import com.minghui.pay.common.notify.disruptor.base.DisruptorEventFactory;
@Component
public class TestDisruptorHelper extends BaseDisruptorHelper<TestData>{
	private static final int QUEUE_SIZE = 1024;
	private static final Logger logger = LoggerFactory.getLogger(TestDisruptorHelper.class);
	@Autowired
	private List<ConsumerHandler<TestData>> list;
	
	@Autowired
	private Executor taskExecutor;
	@Override
	protected WaitStrategy getStrategy() {
		  return new BlockingWaitStrategy();
	}
	@Override
	protected int getQueueSize() {
		return QUEUE_SIZE;
	}

	@Override
	protected EventFactory<DisruptorEvent<TestData>> eventFactory() {
		return new DisruptorEventFactory<TestData>();
	}
	

	@Override
	protected Executor getTaskExecutor() {
		return taskExecutor;
	}
	@Override
	protected WorkHandler<DisruptorEvent<TestData>>[] getconsumerHandler() {
	  int size = list.size();
	  logger.info("<<<<<<<<<<<<<<<<<<<{}已开启{}个消费者>>>>>>>>>>>>>>>>>", "TestDisruptorHelper", size);
	  ConsumerHandler<TestData>[] onsumerHandlers = (ConsumerHandler<TestData>[]) list.toArray(new ConsumerHandler[size]);
      return onsumerHandlers;
	}

	
}
