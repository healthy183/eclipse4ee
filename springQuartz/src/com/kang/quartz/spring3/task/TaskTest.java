package com.kang.quartz.spring3.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		new ClassPathXmlApplicationContext("com/kang/quartz/spring3/task/test.xml");
	}

}
