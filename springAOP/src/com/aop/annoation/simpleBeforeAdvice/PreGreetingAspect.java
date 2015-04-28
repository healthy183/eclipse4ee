package com.aop.annoation.simpleBeforeAdvice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //注释表示其为一个切面
public class PreGreetingAspect {

	@Before("execution(* greetTo(..))")//定义切点和adivce类型
	public void beforeGreenting(){
		System.out.println("how are you!");
	}
	
	
}
