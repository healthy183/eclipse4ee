package com.kang.model;

// Generated 2012-12-26 9:59:48 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MyUsr generated by hbm2java
 */
@Entity
@Table(name = "myUsr", schema = "dbo", catalog = "supCRM")
public class MyUsr implements java.io.Serializable {

	private int usrId;
	private String usrNum;
	private String usrName;
	private String usrPwd;
	private Integer usrLv;
	private String usrRole;
	private Date usrUdtTime;
	private String usrBz;
	private String usrStatus;
	private Set<UsrAreaBrandLink> usrAreaBrandLinks = new HashSet<UsrAreaBrandLink>(0);

	public MyUsr() {
	}

	public MyUsr(int usrId) {
		this.usrId = usrId;
	}

	public MyUsr(int usrId, String usrNum, String usrName,
			String usrPwd, Integer usrLv, String usrRole,
			Date usrUdtTime, String usrBz, String usrStatus,
			Set<UsrAreaBrandLink> usrAreaBrandLinks) {
		this.usrId = usrId;
		this.usrNum = usrNum;
		this.usrName = usrName;
		this.usrPwd = usrPwd;
		this.usrLv = usrLv;
		this.usrRole = usrRole;
		this.usrUdtTime = usrUdtTime;
		this.usrBz = usrBz;
		this.usrStatus = usrStatus;
		this.usrAreaBrandLinks = usrAreaBrandLinks;
	}

	@Id
	@GeneratedValue
	@Column(name = "usrId", unique = true, nullable = false)
	public int getUsrId() {
		return this.usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	@Column(name = "usrNum")
	public String getUsrNum() {
		return this.usrNum;
	}

	public void setUsrNum(String usrNum) {
		this.usrNum = usrNum;
	}

	@Column(name = "usrName")
	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	@Column(name = "usrPwd")
	public String getUsrPwd() {
		return this.usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	@Column(name = "usrLV")
	public Integer getUsrLv() {
		return this.usrLv;
	}

	public void setUsrLv(Integer usrLv) {
		this.usrLv = usrLv;
	}

	@Column(name = "usrRole")
	public String getUsrRole() {
		return this.usrRole;
	}

	public void setUsrRole(String usrRole) {
		this.usrRole = usrRole;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "usrUdtTime", length = 23)
	public Date getUsrUdtTime() {
		return this.usrUdtTime;
	}

	public void setUsrUdtTime(Date usrUdtTime) {
		this.usrUdtTime = usrUdtTime;
	}

	@Column(name = "usrBZ")
	public String getUsrBz() {
		return this.usrBz;
	}

	public void setUsrBz(String usrBz) {
		this.usrBz = usrBz;
	}

	@Column(name = "usrStatus", length = 50)
	public String getUsrStatus() {
		return this.usrStatus;
	}

	public void setUsrStatus(String usrStatus) {
		this.usrStatus = usrStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "myUsr")
	public Set<UsrAreaBrandLink> getUsrAreaBrandLinks() {
		return this.usrAreaBrandLinks;
	}

	public void setUsrAreaBrandLinks(Set<UsrAreaBrandLink> usrAreaBrandLinks) {
		this.usrAreaBrandLinks = usrAreaBrandLinks;
	}

}
