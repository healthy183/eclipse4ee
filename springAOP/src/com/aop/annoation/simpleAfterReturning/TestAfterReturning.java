package com.aop.annoation.simpleAfterReturning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestAfterReturning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		
		String path ="com/aop/annoation/simpleAfterReturning/annotationBeforeAdvice.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		
		Iwaiter waiter = (Iwaiter)applicationContext.getBean("naughtWaiter");
		waiter.serveTo("梁健康");
		
	}

}
