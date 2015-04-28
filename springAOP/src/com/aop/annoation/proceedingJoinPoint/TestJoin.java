package com.aop.annoation.proceedingJoinPoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/proceedingJoinPoint/JoinPoint.xml");
		Iwaiter w = (Iwaiter)app.getBean("joinWaiter");
		w.greetTo("ljk");
		w.serveTo("梁健康");
	}

}
