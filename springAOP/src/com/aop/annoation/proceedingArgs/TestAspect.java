package com.aop.annoation.proceedingArgs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {

	@Before("target(com.aop.annoation.proceedingArgs.NaughtWaiter) && args(name,time)")
	public void bindJoinPointParameter(String name,int time){//arg的name,time必须相同
		System.out.println("开始");
		System.out.println("arg0:"+name+" arg1:"+time);
		System.out.println("结束");
	}
	
	
}
