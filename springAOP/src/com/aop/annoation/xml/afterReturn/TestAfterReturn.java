package com.aop.annoation.xml.afterReturn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAfterReturn {

	
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/xml/afterReturn/afterReturn.xml");
		AfterReuturn afterReturn =(AfterReuturn)app.getBean("afterReuturn");
		afterReturn.returnMethod(123);
	}
}
