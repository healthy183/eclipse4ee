package com.aop.annoation.xml.around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProceeding {
	
	
	public static void main(String[] args) {
	
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/xml/around/proceeding.xml");
		ProceedingJoinPoint p = (ProceedingJoinPoint)app.getBean("proceedingJoinPoint");
		p.pro("s");
	}
}
