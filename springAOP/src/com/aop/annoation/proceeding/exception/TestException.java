package com.aop.annoation.proceeding.exception;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/proceeding/exception/exception.xml");
		//Seller s = (Seller)app.getBean("smartSeller");
		SmartSeller s = (SmartSeller)app.getBean("smartSeller");
		//s.checkBill(1);
		s.checkBill(1);
	}

}
