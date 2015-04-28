package com.kang.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerRunner {

	
	public static void main(String[] args) {
		
		try {
			JobDetail jobDetail = new JobDetail("job1_1","jgroup1",SimpleJob.class);
			
			SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");
			simpleTrigger.setStartTime(new Date());//现在执行
			simpleTrigger.setRepeatInterval(1000);//一秒一次
			simpleTrigger.setRepeatCount(10);//执行五次
			
			SchedulerFactory schedulerFactory =	new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			
			scheduler.scheduleJob(jobDetail, simpleTrigger);//注册
			scheduler.start();//开始
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
