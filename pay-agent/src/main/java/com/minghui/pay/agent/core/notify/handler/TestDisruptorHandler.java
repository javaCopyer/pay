package com.minghui.pay.agent.core.notify.handler;

import org.springframework.stereotype.Component;

import com.minghui.pay.agent.core.notify.data.TestData;
import com.minghui.pay.common.notify.disruptor.handler.IDisruptorHandler;
@Component
public class TestDisruptorHandler implements IDisruptorHandler<TestData>{

	@Override
	public void execute(TestData data) {
		System.out.println(data.getName() + "||" + data.getValue());
	}

}
