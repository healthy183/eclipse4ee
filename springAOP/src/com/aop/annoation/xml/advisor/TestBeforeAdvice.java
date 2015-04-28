package com.aop.annoation.xml.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;



public class TestBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object obj)
			throws Throwable {
		System.out.println("start");
		System.out.println("method:"+method);
		System.out.println(arg1[0]+" "+arg1[1]);
		System.out.println(obj.getClass());
	}

}
