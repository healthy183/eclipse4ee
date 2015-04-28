package com.aop.annoation.proceedingJoinPoint;

import com.aop.annoation.simpleAfterReturning.NeedTest;
import com.aop.interfaces.Iwaiter;

public class NaughtWaiter implements Iwaiter {

	@Override
	public void greetTo(String usrName) {
		System.out.println("greetTo "+usrName);
	}
	
	//@NeedTest
	@Override
	public void serveTo(String usrName) {
		System.out.println("serveTo "+usrName);
	}

}
