package com.aop.annoation.xml.around;

public class Aspect {

	public void aroundMethod(org.aspectj.lang.ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("start");
		//pjp.pro()
		pjp.proceed();
		System.out.println("end");
	}
	
}
