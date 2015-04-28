package com.kang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kang.model.SysUsers;
import com.kang.service.IuserService;

public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IuserService  iuserService = (IuserService)applicationContext.getBean("userServiceImpl");
		SysUsers user = iuserService.findById(100);
		System.out.println(user.getUsrname());
	}

}
