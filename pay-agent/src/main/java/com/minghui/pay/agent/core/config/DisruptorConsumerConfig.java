package com.minghui.pay.agent.core.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.minghui.pay.agent.core.notify.data.TestData;
import com.minghui.pay.common.notify.disruptor.base.ConsumerHandler;
import com.minghui.pay.common.notify.disruptor.handler.IDisruptorHandler;

/***
 * 添加消费者即可
* <p>Title: DisruptorConfig.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月20日  
* @version 1.0
 */
@Configuration
public class DisruptorConsumerConfig {
	@Bean
	public ConsumerHandler<TestData> testConsumer1(@Qualifier("testDisruptorHandler") IDisruptorHandler<TestData> testDisruptorHandler) {
		ConsumerHandler<TestData> testConsumer = new ConsumerHandler<TestData>();
		testConsumer.setIdisruptorHandler(testDisruptorHandler);
		testConsumer.setConsumerName("testConsumer1");
		return testConsumer;
	}
	
	@Bean
	public ConsumerHandler<TestData> testConsumer2(@Qualifier("testDisruptorHandler") IDisruptorHandler<TestData> testDisruptorHandler) {
		ConsumerHandler<TestData> testConsumer = new ConsumerHandler<TestData>();
		testConsumer.setIdisruptorHandler(testDisruptorHandler);
		testConsumer.setConsumerName("testConsumer2");
		return testConsumer;
	}
	
	@Bean
	public ConsumerHandler<TestData> testConsumer3(@Qualifier("testDisruptorHandler") IDisruptorHandler<TestData> testDisruptorHandler) {
		ConsumerHandler<TestData> testConsumer = new ConsumerHandler<TestData>();
		testConsumer.setIdisruptorHandler(testDisruptorHandler);
		testConsumer.setConsumerName("testConsumer3");
		return testConsumer;
	}
}
