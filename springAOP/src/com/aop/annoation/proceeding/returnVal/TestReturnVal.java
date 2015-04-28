package com.aop.annoation.proceeding.returnVal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.annoation.simpleDeclareParents.Seller;

public class TestReturnVal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/proceeding/returnVal/returnVal.xml");
		Seller s = (Seller)app.getBean("seller");
		//SmallerSeller s = (SmallerSeller)app.getBean("seller");
		s.sell("a","b");
	}

}
