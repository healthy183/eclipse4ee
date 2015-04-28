package com.aop.annoation.simpleDeclareParents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class DeclareParentsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String configPath = "com/aop/annoation/simpleDeclareParents/declareParentsTest.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Iwaiter waiter = (Iwaiter)ctx.getBean("waiter");
		
		//waiter.serveTo("梁健康");
		waiter.greetTo("梁健康");
		Seller seller = (Seller)waiter;
		seller.sell("A","梁健康");
		
	}

}
