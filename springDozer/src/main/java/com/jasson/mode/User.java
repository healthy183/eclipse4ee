package main.java.com.jasson.mode;

public class User {
	private int id;
	private String name;
	private String password;
	private Info info;
	private String option;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}