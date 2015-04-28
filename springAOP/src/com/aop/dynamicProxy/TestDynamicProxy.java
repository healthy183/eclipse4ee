package com.aop.dynamicProxy;

import java.lang.reflect.Proxy;

import com.aop.interfaces.IforumService;

public class TestDynamicProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IforumService target = new ForumServiceImpl();
		
		PerformanceHandler handler = new PerformanceHandler(target);
		
		IforumService proxy = (IforumService)Proxy.newProxyInstance
				(target.getClass().getClassLoader(),
						target.getClass().getInterfaces(), handler);
		
		proxy.removeTop(1);
		proxy.removeForum(2);
		
	}

}
