package com.aop.annoation.xml.exception;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.annoation.simpleDeclareParents.Seller;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/xml/exception/exception.xml");
		SmartSeller s =(SmartSeller)app.getBean("smartSeller");
		s.checkBill(2);
	}

}
