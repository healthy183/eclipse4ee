package com.kang.quartz.spring25.MethodInvokingJobDetailFactoryBean;

import java.util.Date;

public class MyTaskByMethod {
	
	private int counter1=0;
	private int counter2=0;
	private int counter3=0;
	
	public void job01(){
		 System.out.println(new Date()+":  任务方法job01 被执行..."+(++counter1));
	}
	
	public void job02(){
		 System.out.println(new Date()+":  任务方法job02 被执行..."+(++counter2));
	}
	
	public void job03(){
		 System.out.println(new Date()+":  任务方法job03 被执行..."+(++counter3));
	}
	

}
