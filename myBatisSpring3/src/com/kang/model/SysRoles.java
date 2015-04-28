package com.kang.model;

import java.util.List;

public class SysRoles implements java.io.Serializable {
	
	private Integer roleId;
	private String roleName;
	private String roleUrl;
	private List<UsrRoleLink> linkList;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleUrl() {
		return roleUrl;
	}
	public void setRoleUrl(String roleUrl) {
		this.roleUrl = roleUrl;
	}
	public List<UsrRoleLink> getLinkList() {
		return linkList;
	}
	public void setLinkList(List<UsrRoleLink> linkList) {
		this.linkList = linkList;
	}
	
	

}
