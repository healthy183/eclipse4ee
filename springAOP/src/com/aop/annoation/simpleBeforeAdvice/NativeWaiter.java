package com.aop.annoation.simpleBeforeAdvice;

import com.aop.interfaces.Iwaiter;

public class NativeWaiter implements Iwaiter {

	@Override
	public void greetTo(String usrName) {
		System.out.println("greet to" + usrName);
	}

	@Override
	public void serveTo(String usrName) {
		System.out.println("serveTo to" + usrName);
	}

}
