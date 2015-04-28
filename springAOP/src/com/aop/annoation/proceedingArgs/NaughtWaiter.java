package com.aop.annoation.proceedingArgs;

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
	
	public void smileTo(int time, String name){
		System.out.println("对"+name+"笑了"+time+"次");
	}
	
	public void smileTo(String names,int time){
		System.out.println("对"+names+"笑了"+time+"次");
	}
}
