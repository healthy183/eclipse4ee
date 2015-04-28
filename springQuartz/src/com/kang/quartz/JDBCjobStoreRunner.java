package com.kang.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class JDBCjobStoreRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		try {
			StdSchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler =  sf.getScheduler();
			String[] triggerGroups = scheduler.getTriggerGroupNames();
			
			for(int i = 0;i<triggerGroups.length;i++){
				
				String[] triggers = scheduler.getTriggerNames(triggerGroups[i]);
				
				for(int j = 0;j<triggers.length;j++){
					
					Trigger tg =  scheduler.getTrigger(triggers[j],triggerGroups[i]);
					if(tg instanceof SimpleTrigger && tg.getFullName().equals("tgroup1.trigger1_1")){
						scheduler.rescheduleJob(triggers[j],triggerGroups[i], tg);
					}
				}
			}
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}

}
