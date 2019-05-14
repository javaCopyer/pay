package com.minghui.pay.agent;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minghui.pay.agent.core.notify.helper.TestDisruptorHelper;
import com.minghui.pay.agent.core.pojo.DeployAuthToken;
import com.minghui.pay.common.exception.SystemException;
import com.minghui.pay.service.IPayAgentService;

/**
 * 
* <p>Title: MainApplication.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月23日  
* @version 1.0
 */
@RestController
@SpringBootApplication
//springboot默认扫描启动类所在包内的bean，因为启动类不是在跟包下，所以要重新配置扫描
@ComponentScan(basePackages = {"com.minghui.pay.agent",
		"com.minghui.pay.service",
		"com.minghui.pay.common",
        "com.minghui.pay.dao"})
@MapperScan("com.minghui.pay.dao")
public class MainApplication extends SpringBootServletInitializer{
	private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);
	@Autowired
	private TestDisruptorHelper testDisruptorHelper;
	@Autowired
	private DeployAuthToken deployAuthToken;
	@Autowired
	private IPayAgentService payAgentService;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private ValueOperations<String, Object> valueOperation;
	
	@Value("${spring.datasource.url}")
	private String url;
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MainApplication.class);
		//banner开关
		app.setBannerMode(Mode.CONSOLE); 
		app.run(args);
//		SpringApplication.run(Sb1Application.class, args);
	}
	
	@GetMapping("index")
	public void index(HttpServletRequest request) throws SystemException {
		valueOperation.set("zhang_ke", "张杰1");
		logger.info("========" + deployAuthToken.getExpires());
		System.out.println(valueOperation.get("zhang_ke"));
	}
}

