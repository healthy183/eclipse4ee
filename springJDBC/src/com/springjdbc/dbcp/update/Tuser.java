package com.springjdbc.dbcp.update;

public class Tuser implements java.io.Serializable{

	private Integer userId;
	private String userName;
	private String userPwd;
	
	public Tuser() {
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
	};
	
	
	
	
}
