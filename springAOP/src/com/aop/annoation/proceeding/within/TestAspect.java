package com.aop.annoation.proceeding.within;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {
	
	@Before("@within(m)")
	public void bindTypeAnnoOjbect(Monitorable m){
		System.out.println("start");
		System.out.println(m.getClass().getName());
		System.out.println("end");
	}
	
}
