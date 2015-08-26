package com.kang.quartz.spring3.task;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Task2 {

	@Scheduled(cron="0/2   *   *     *   *     ?")
	public  void testTwoPrint(){
		
		System.out.println("=============>["+Thread.currentThread().getId()+"]"+"2秒任务执行时间:"
				+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		
		System.out.println("start:"
			+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		
		System.out.println("=============>["+Thread.currentThread().getId()+"]"+"2秒任务完成时间:"
				+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
	}
}
