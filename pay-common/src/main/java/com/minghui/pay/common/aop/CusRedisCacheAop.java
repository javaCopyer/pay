package com.minghui.pay.common.aop;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.minghui.pay.common.annotation.CusRedisCacheable;

/**
 * redis加入缓存AOP
* <p>Title: CusRedisCacheAop.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月22日  
* @version 1.0
 */
@Component
@Aspect
public class CusRedisCacheAop {
	
	private static final Logger logger = LoggerFactory.getLogger(CusRedisCacheAop.class);
	
	
	@Pointcut(value = "@annotation(com.minghui.pay.common.annotation.CusRedisCacheable)")
	public void pointcutMethod(){};
	
	/**
	 * 环绕处理
	 * 检查redis是否存在该key,不存在则调用缓存系统刷新缓存
	 * @param joinPoint
	 * @return
	 */
	@Around(value = "pointcutMethod()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Method targetMethod = ((MethodSignature)joinPoint.getSignature()).getMethod();
		CusRedisCacheable cusRedisCacheable = targetMethod.getAnnotation(CusRedisCacheable.class);
		//redis存储的key
		String key = cusRedisCacheable.key();
		//时间格式 默认分钟
		TimeUnit timeUnit = cusRedisCacheable.timeUnit();
		//过期时间 默认0，即不设置过期时间
		long expire = cusRedisCacheable.expire();
		
		
		
		
		/** 参数列表 **/
		Object[] args = joinPoint.getArgs(); 
		
		/** key默认为第一个参数 **/
		try {
			// 调用目标方法
			return joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
