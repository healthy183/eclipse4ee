package com.aop.annoation.simpleAfterReturning;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
		
		@AfterReturning("@annotation(com.aop.annoation.simpleAfterReturning.NeedTest)")
		public void needTestFun(){
			System.out.println("后置advice!");
		}
	
}
