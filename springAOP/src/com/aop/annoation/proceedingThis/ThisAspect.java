package com.aop.annoation.proceedingThis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.aop.interfaces.Iwaiter;

@Aspect
public class ThisAspect {

	@Before("this(waiter)")//两个waiter一定要一样
	public void bindProxyObj(Iwaiter waiter){
		System.out.println("start");
		System.out.println(waiter.getClass().getName());
		System.out.println("end");
	}
}
