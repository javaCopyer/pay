package com.minghui.pay.common.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * 
* <p>Title: ThreadPoolConfig.java</p>  
* <p>Description: </p>  
* @author sky
* @date 2019年3月23日  
* @version 1.0
 */
@Configuration
public class ThreadPoolConfig {
	@Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //线程池创建时候初始化的线程数
        executor.setCorePoolSize(10);
        //线程池维护线程所允许的空闲时间 超过时间自动销毁
        executor.setKeepAliveSeconds(60);
        //线程池维护线程的最大数量
        executor.setMaxPoolSize(80);
        //用来缓冲执行任务的队列
        executor.setQueueCapacity(500);
        //设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        executor.setAwaitTerminationSeconds(60);
        //这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
