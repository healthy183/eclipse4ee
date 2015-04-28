package com.aop.annoation.xml.arg;

public class AspectMethod {

	
	public void beforeArg(String usrName,String usrPwd){
		
		System.out.println("start");
		System.out.println("usrName: "+usrName);
		System.out.println("usrPwd: "+usrPwd);
		System.out.println("end");
	}
	
}
