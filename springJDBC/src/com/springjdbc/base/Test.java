package com.springjdbc.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	private ApplicationContext app = null;
	private UserBaseDao userBaseDao = null;
	
	public Test() {
		app = new ClassPathXmlApplicationContext("com/springjdbc/dbcp/update/springJDBC.xml");
		userBaseDao = (UserBaseDao)app.getBean("userBaseDao");
	}
	
	public UserBaseDao getUserBaseDao() {
		return userBaseDao;
	}

	public static void main(String[] args) {
		
		Test t = new Test();
		t.getUserBaseDao().saveUser();
	}	
	
	
}
