package com.kang.quartz;

import java.text.ParseException;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerRunner {
		
	/**cron表达式 */
    /***
		秒     分钟     小时    日期    月份     星期      年(可选)	
	   0/1   *   *     *   *     ?             //现在开始每一秒执行一次
		0   10   13    *   *     ?             //每日 13点10分0秒执行
	   0/1 9-10  13    *   *     ?     2012    //2012年每日 13点9分10分每一秒执行一次
	   0/1 9,10  13    *   *     ?     2012    //2012年每日 13点9分10分每一秒执行一次(同上)
	    0   20   13    ?   11   sun            //每年 的11月星期天      13点20分 执行
	    0   26   13    ?   11  wed-sun         //每年 的11月星期三到日      13点26分 执行
	    0   15   14    L   11    ?             //每年 的11月最后一日 14点15分执行
	    0   16   14    ?   11    3L(LW 代表最后一个工作日) //每年 的11月最后一个星期一 14点16分执行(为什么最后一个星期日不行?)
	    0   16   14    15w *     ?            //每月  距离15号最近的工作日的14时，16分执行
	    0   16   14    ?   *     5#3            //每月  第三个星期四 的14时，16分执行
	*
	***/
	public static void main(String[] args) {
		
		try {
			
			JobDetail jobDetail = new JobDetail("job_1","group1",SimpleJob.class);
			
			CronTrigger cronTrigger = new CronTrigger("trigger_1","tgroup1");
			
			CronExpression cronExpression = new CronExpression("45   38   14    ?   *  5#3");
			
			cronTrigger.setCronExpression(cronExpression);
			
			SchedulerFactory schedulerFactory =	new StdSchedulerFactory();
			
			Scheduler scheduler = schedulerFactory.getScheduler();
			
			scheduler.scheduleJob(jobDetail, cronTrigger);//注册
			
			scheduler.start();//开始
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
}
