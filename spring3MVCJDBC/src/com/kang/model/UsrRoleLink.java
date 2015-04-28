package com.kang.model;

public class UsrRoleLink implements java.io.Serializable {

	private Integer	linkId;
	private Integer usrid;
	private Integer roleid;
	
	public UsrRoleLink() {
		super();
	}

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public Integer getUsrid() {
		return usrid;
	}

	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	
	
	
	
	
	
}
