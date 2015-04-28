package com.kang.quartz.spring25.JobDetailBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TaskA extends QuartzJobBean {

	private int count = 1;
	
	
	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext)
			throws JobExecutionException {

		System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd hh-mm-ss")+"taskA第"+(count+=1)+"次执行!");
		
	}

}
