package com.aop.annoation.proceeding.within;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestWithin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/proceeding/within/within.xml");
		Iwaiter w = (Iwaiter)app.getBean("naughtWaiter");
		((NaughtWaiter)w).greetTo("梁健康");
		((NaughtWaiter)w).greetTo("abc");
	}

}
