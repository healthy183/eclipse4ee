package com.aop.annoation.proceeding.returnVal;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {

	@AfterReturning(value="target(com.aop.annoation.proceeding.returnVal.SmallerSeller)",returning="retVal")
	public void bingReturnValue(int retVal){
		System.out.println("start");
		System.out.println("retVal:"+retVal);
		System.out.println("end");
	}
}
