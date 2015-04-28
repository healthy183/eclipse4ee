package com.aop.annoation.proceedingJoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspectTestAspectForPro {

	@Around("execution(* greetTo(..)) && target(com.aop.annoation.proceedingJoinPoint.NaughtWaiter)")
	public void PointAccess(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("join proceeding success!");

		System.out.println("arg[0]"+pjp.getArgs()[0]);
	
		System.out.println("signature:"+pjp.getTarget().getClass());
		
		pjp.proceed();
		
		System.out.println("join end!");
	}
	
}
