package com.minghui.pay.agent.core.initialize;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.minghui.pay.agent.core.notify.helper.TestDisruptorHelper;
/**
 * 
* <p>Title: ApplicationInitializationBean.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月23日  
* @version 1.0
 */
@Component
public class ApplicationInitializationBean implements InitializingBean, DisposableBean{
	@Autowired
	private TestDisruptorHelper testDisruptorHelper;
	@Override
	public void destroy() throws Exception {
		testDisruptorHelper.shutdown();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		testDisruptorHelper.init();
	}

}
 