package main.java.com.jasson.mode;

public class UserVO {
	private int id;
	private String userName;
	private String password;
	private InfoVO info;
	private String option;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InfoVO getInfo() {
		return info;
	}

	public void setInfo(InfoVO info) {
		this.info = info;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	
}