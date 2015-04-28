package com.aop.annoation.xml.declareParents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestdeclareParents {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/xml/declareParents/declareParents.xml");
		Iwaiter w = (Iwaiter) app.getBean("naiveWaiter");
		((Seller)w).sell("梁健康","abc");
	}
}
