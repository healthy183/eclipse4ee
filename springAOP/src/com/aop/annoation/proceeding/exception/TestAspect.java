package com.aop.annoation.proceeding.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspect {

	@AfterThrowing(pointcut="execution(* com.aop.annoation.proceeding.exception..*.check*(..))",throwing="iae")
	public void testException(IllegalArgumentException iae){
		System.out.println("start");
		System.out.println(iae.getMessage());
		System.out.println("end");
	}
	
}
