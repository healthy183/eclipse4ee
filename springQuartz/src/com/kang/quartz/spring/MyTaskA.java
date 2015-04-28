package com.kang.quartz.spring;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyTaskA extends QuartzJobBean {
	 
	private int counter = 1;
	 
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// 默认执行任务的方法
        System.out.println(new Date()+":  MyTaskA 被执行..."+(counter+=1));
        }

}
