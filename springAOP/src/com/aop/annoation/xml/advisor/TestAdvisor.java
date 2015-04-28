package com.aop.annoation.xml.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestAdvisor {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/xml/advisor/advisor.xml");
		Iwaiter w =(Iwaiter)app.getBean("naiveWaiter");
		((NaiveWaiter)w).smile("梁健康","123");
	}
}
