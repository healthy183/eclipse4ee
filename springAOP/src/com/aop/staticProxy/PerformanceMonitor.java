package com.aop.staticProxy;

public class PerformanceMonitor {

	private static ThreadLocal<MethodPerformance> performanceRecord =
			new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method){
		System.out.println("this is begin!");
		
		MethodPerformance methodPerformance = new MethodPerformance(method);
		performanceRecord.set(methodPerformance);
	}
	
	
	public static void end(){
		System.out.println("this is end!");
		
		MethodPerformance methodPerformance = performanceRecord.get();
		methodPerformance.printMessage();
	}
	
}
