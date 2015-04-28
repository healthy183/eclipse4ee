package com.aop.annoation.xml.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


public class TestAspect {

	public void testException(IllegalArgumentException iae){
		System.out.println("start");
		System.out.println(iae.getMessage());
		System.out.println("end");
	}
	
}
