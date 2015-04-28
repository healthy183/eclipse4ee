package com.aop.annoation.xml.before;

import com.aop.interfaces.Iwaiter;

public class NaiveWaiter implements Iwaiter {

	@Override
	public void greetTo(String usrName) {
		System.out.println("greetTo "+ usrName);
	}

	@Override
	public void serveTo(String usrName) {
		System.out.println("serveTo "+usrName);
	}

}
