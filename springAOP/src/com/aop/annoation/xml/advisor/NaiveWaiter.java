package com.aop.annoation.xml.advisor;

import com.aop.interfaces.Iwaiter;

public class NaiveWaiter implements Iwaiter {

	@Override
	public void greetTo(String usrName) {

	}

	@Override
	public void serveTo(String usrName) {

	}

	public void smile(String usrName,String usrPwd){
		System.out.println("usrName:"+usrName+" usrPwd"+usrPwd);
	}
}
