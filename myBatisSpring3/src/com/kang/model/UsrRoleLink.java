package com.kang.model;

import java.util.List;

public class UsrRoleLink implements java.io.Serializable {

	private Integer linkId;
	private SysRoles sysRoles;

	public UsrRoleLink() {
	}

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public SysRoles getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(SysRoles sysRoles) {
		this.sysRoles = sysRoles;
	}

}
