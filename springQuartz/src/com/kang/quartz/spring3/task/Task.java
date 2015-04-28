package com.kang.quartz.spring3.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Task {

	@Scheduled(cron="0/1   *   *     *   *     ?")
	public  void testTwoPrint(){
		System.out.println("start");
	}
}
