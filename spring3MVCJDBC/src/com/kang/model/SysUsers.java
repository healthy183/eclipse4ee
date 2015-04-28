package com.kang.model;

public class SysUsers implements java.io.Serializable {

	
	private Integer usrid;
	private String usrname;
	private String usrpwd;
	private Integer usrtype;
	private Integer usrmgr;
	
	private String leanderName;
	
	


	public String getLeanderName() {
		return leanderName;
	}


	public void setLeanderName(String leanderName) {
		this.leanderName = leanderName;
	}


	public SysUsers() {
	}


	public Integer getUsrid() {
		return usrid;
	}


	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}


	public String getUsrname() {
		return usrname;
	}


	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}


	public String getUsrpwd() {
		return usrpwd;
	}


	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}


	public Integer getUsrtype() {
		return usrtype;
	}


	public void setUsrtype(Integer usrtype) {
		this.usrtype = usrtype;
	}


	public Integer getUsrmgr() {
		return usrmgr;
	}


	public void setUsrmgr(Integer usrmgr) {
		this.usrmgr = usrmgr;
	}
	
}
