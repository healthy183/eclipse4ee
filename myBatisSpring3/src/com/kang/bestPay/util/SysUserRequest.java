package com.kang.bestPay.util;


public class SysUserRequest {
	
	private int usrid;
	private String usrname;
	private String usrpwd;
	private Integer usrtype;
	private Integer usrmgr;
	
	private TPageParameter page;
	
	
	
	
	
	public SysUserRequest() {
		super();
	}

	public SysUserRequest(int usrid, String usrname, String usrpwd,
			Integer usrtype, Integer usrmgr, TPageParameter page) {
		super();
		this.usrid = usrid;
		this.usrname = usrname;
		this.usrpwd = usrpwd;
		this.usrtype = usrtype;
		this.usrmgr = usrmgr;
		this.page = page;
	}

	public int getUsrid() {
		return usrid;
	}

	public void setUsrid(int usrid) {
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

	public TPageParameter gettPageParameter() {
		return page;
	}

	public void settPageParameter(TPageParameter page) {
		this.page = page;
	}
	
	
	
	
	
	
}
