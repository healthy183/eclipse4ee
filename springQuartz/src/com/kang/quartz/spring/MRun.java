package com.kang.quartz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");

	}

}
