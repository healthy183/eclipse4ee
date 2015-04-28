package com.aop.staticProxy;

public class MethodPerformance {

	private long begin;
	private long end;
	private String serviceMethod;
	
	
	public MethodPerformance(String serviceMethod){
		this.serviceMethod = serviceMethod;
		this.begin = System.currentTimeMillis();
	}
	
	public void printMessage(){
		this.end =	System.currentTimeMillis();
		System.out.println(end - begin+"秒");
	}
	
	
}
