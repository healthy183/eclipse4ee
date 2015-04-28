package com.javaSE.list;

import java.util.ArrayList;
import java.util.List;

class User{
	private Integer userId;
	private String userName;
	
	
	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
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
	
}

public class ListLongValue {

	public static void main(String[] args) {
		
		List<User> listUser = new ArrayList<User>();
		listUser.add(new User(1,"梁健康"));
		listUser.add(new User(2,"梁伟雄"));
		
		//System.out.println(((Number)listUser.get(0)).longValue());
	}

}
