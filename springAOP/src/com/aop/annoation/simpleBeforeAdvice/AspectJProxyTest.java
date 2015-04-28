package com.aop.annoation.simpleBeforeAdvice;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.aop.interfaces.Iwaiter;

public class AspectJProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Iwaiter target = new NativeWaiter(); 
		
		AspectJProxyFactory factory = new AspectJProxyFactory();
	
		factory.setTarget(target);//设置目标对象
		
		factory.addAspect(PreGreetingAspect.class);//添加切面类
		
		Iwaiter proxy = factory.getProxy();//生成织入切面的代理对象
		
		proxy.greetTo("梁健康");
		proxy.serveTo("梁健康");
	}

}
