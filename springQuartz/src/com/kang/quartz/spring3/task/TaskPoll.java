package com.kang.quartz.spring3.task;

import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class TaskPoll {

	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	
	@Scheduled(cron="0/5   *   *     *   *     ?")
	public void execute(){
		
		//定时任务清空线程池队列
		BlockingQueue<Runnable> queues = threadPoolTaskExecutor.getThreadPoolExecutor().getQueue();
		//Runnable runnable = queues.poll();
		System.out.println("====================================>清空队列!");
		queues.clear();
		
	}
	
	
	
	
}
