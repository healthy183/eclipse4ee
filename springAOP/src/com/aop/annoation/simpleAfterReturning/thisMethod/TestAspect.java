package com.aop.annoation.simpleAfterReturning.thisMethod;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class TestAspect {
	
	@AfterReturning("this(com.aop.annoation.simpleDeclareParents.Seller)")
	public void thisTest(){
		System.out.println("this is this() method!");
	}
	
	
}
