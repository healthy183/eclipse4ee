package main.java.com.jasson.mode;

import java.util.Date;

/**
 * @author jgao1
 * 
 */
public class Info {
	private int id;
	private Date createDate;
	private GenderType gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}
}