package com.minghui.pay.agent.core.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * springmvc 配置
* <p>Title: WebMvcConfig.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月25日  
* @version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	private CookieInterceptor cookieInterceptor;
	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(cookieInterceptor).addPathPatterns("/**");
	}

}
