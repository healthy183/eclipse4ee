package com.kang.quartz.spring25.MethodInvokingJobDetailFactoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext("com/kang/quartz/spring25/MethodInvokingJobDetailFactoryBean/methodInvokingJobDetailFactoryBean.xml");
	}
}
