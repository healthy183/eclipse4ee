package com.springjdbc.base;

import javax.persistence.Id;


public class TestUser implements java.io.Serializable {

	@Id
	private Integer userId;
	private String userName;
	private String userPwd;
	
	
	public TestUser() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
