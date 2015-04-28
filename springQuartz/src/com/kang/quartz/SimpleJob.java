package com.kang.quartz;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {

		
		System.out.println(jobCtx.getTrigger().getName()
			+" triggered.time is:"+DateFormatUtils.format(new Date(),"yyyy-MM-dd"));
		
	}

}
