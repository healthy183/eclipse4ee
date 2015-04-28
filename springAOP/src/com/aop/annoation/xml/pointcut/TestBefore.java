package com.aop.annoation.xml.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestBefore {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/xml/pointcut/pointcut.xml");
		Iwaiter w = (Iwaiter)app.getBean("naiveWaiter");
		w.greetTo("梁健康");
		w.serveTo("梁健康");
	
	}

}
