package com.springjdbc.base;

public class UserBaseDao extends BaseDaoImpl<TestUser> {

	public void saveUser(){
		
		TestUser user = new TestUser();
		user.setUserName("梁健康");
		user.setUserPwd("123");
		save(user);
	}
	
}
