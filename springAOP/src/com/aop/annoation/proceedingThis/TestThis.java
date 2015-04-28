package com.aop.annoation.proceedingThis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestThis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/proceedingThis/thisXml.xml");
		Iwaiter w =(Iwaiter)app.getBean("naughtWaiter");
		w.greetTo("ljk");
	}

}
