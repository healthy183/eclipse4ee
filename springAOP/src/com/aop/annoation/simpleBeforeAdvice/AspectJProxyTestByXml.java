package com.aop.annoation.simpleBeforeAdvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class AspectJProxyTestByXml {

	public static void main(String[] args) {
		
		
		String configPath = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Iwaiter waiter = (Iwaiter)ctx.getBean("waiter");	
		waiter.greetTo("梁健康");
		waiter.serveTo("梁健康");
	}
	
}
