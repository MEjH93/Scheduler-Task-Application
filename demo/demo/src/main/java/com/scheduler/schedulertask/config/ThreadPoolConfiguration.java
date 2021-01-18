package com.scheduler.schedulertask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration {

	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(20);
		threadPoolTaskExecutor.setQueueCapacity(5);
		threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor-");
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}
}