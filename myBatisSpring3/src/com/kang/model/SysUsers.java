package com.kang.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class SysUsers implements java.io.Serializable {
	
	private int usrid;
	private String usrname;
	private String usrpwd;
	private Integer usrtype;
	private Integer usrmgr;
	private List<TReim> treimSet;
	
	// = new HashSet<TReim>();
	public SysUsers() {
	}
	
	
	
	/*public Set<TReim> getTreimSet() {
		return treimSet;
	}

	public void setTreimSet(Set<TReim> treimSet) {
		this.treimSet = treimSet;
	}*/



	public List<TReim> getTreimSet() {
		return treimSet;
	}



	public void setTreimSet(List<TReim> treimSet) {
		this.treimSet = treimSet;
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
	
}
