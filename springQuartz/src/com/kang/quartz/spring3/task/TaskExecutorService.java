package com.kang.quartz.spring3.task;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class TaskExecutorService {

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(2);
		taskExecutor.setQueueCapacity(1000);
		taskExecutor.setMaxPoolSize(5);
		taskExecutor.setKeepAliveSeconds(180);
		//taskExecutor.afterPropertiesSet();
		return taskExecutor;
	}
}
