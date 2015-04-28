package com.kang.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

public class CalendarExample {

	/**
	 * @param args
	 */
	//任务执行排除五一,十一
	
	public static void main(String[] args) {

		try {
			
			StdSchedulerFactory sf = new StdSchedulerFactory();

			Scheduler scheduler = sf.getScheduler();
			
			//法定节日是每年为周期，所以用AnnualCalendar
			AnnualCalendar holidays = new AnnualCalendar();
			//五一劳动节
			Calendar laborDay = new GregorianCalendar();
			laborDay.add(Calendar.MONTH,5);
			laborDay.add(Calendar.DATE,1);
			holidays.setDayExcluded(laborDay,true);//true排除 false不排除
			//十一国庆节
			Calendar nationalDay =	new GregorianCalendar();
			nationalDay.add(Calendar.MONTH,10);
			nationalDay.add(Calendar.DATE,1);
			holidays.setDayExcluded(nationalDay,true);//true排除 false不排除
			//向scheduler注册日历
			scheduler.addCalendar("holidays",holidays,false,false);
			//四月一号 早上 十点
			Date runDate = TriggerUtils.getDateOf(0,0,10,1,4);
			//
			JobDetail job = new JobDetail("job1","group1",SimpleJob.class);
			SimpleTrigger trigger = new SimpleTrigger("trigger1","group1",
					runDate,
					null, 
					SimpleTrigger.REPEAT_INDEFINITELY,
					60L*60L*1000L);
			
			trigger.setCalendarName("holidays");//让trigger应用指定的日历规则
			scheduler.scheduleJob(job,trigger);
			scheduler.start();
			
		} catch (SchedulerException e) {

			
			e.printStackTrace();
		}
		
		
		
	}

}
