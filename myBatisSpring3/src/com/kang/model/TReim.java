package com.kang.model;

import java.util.Date;

public class TReim  implements java.io.Serializable {

	
	private Integer rmid;
	private SysUsers sysUsers;
	private String rmname;
	private String rmdesc;
	private Date rmdate;
	
	public Integer getRmid() {
		return rmid;
	}
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}
	public SysUsers getSysUsers() {
		return sysUsers;
	}
	public void setSysUsers(SysUsers sysUsers) {
		this.sysUsers = sysUsers;
	}
	public String getRmname() {
		return rmname;
	}
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}
	public String getRmdesc() {
		return rmdesc;
	}
	public void setRmdesc(String rmdesc) {
		this.rmdesc = rmdesc;
	}
	public Date getRmdate() {
		return rmdate;
	}
	public void setRmdate(Date rmdate) {
		this.rmdate = rmdate;
	}
	
	
	
	
	
	
}
