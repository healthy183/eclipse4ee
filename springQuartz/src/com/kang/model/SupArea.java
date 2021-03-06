package com.kang.model;

// Generated 2012-12-26 9:59:48 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SupArea generated by hbm2java
 */
@Entity
@Table(name = "supArea", schema = "dbo", catalog = "supCRM")
public class SupArea implements java.io.Serializable {

	private int areaId;
	private String areaNum;
	private String areaName;
	private String areaBz;
	private String areaStatus;
	private Set<UsrAreaBrandLink> usrAreaBrandLinks = new HashSet<UsrAreaBrandLink>(0);
	private Set<SupStore> supStores = new HashSet<SupStore>(0);

	public SupArea() {
	}

	public SupArea(int areaId) {
		this.areaId = areaId;
	}

	public SupArea(int areaId, String areaNum, String areaName, String areaBz,
			String areaStatus, Set<UsrAreaBrandLink> usrAreaBrandLinks,
			Set<SupStore> supStores) {
		super();
		this.areaId = areaId;
		this.areaNum = areaNum;
		this.areaName = areaName;
		this.areaBz = areaBz;
		this.areaStatus = areaStatus;
		this.usrAreaBrandLinks = usrAreaBrandLinks;
		this.supStores = supStores;
	}

	@Id
	@Column(name = "areaId", unique = true, nullable = false)
	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	@Column(name = "areaNum")
	public String getAreaNum() {
		return this.areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}

	@Column(name = "areaName")
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "areaBZ")
	public String getAreaBz() {
		return this.areaBz;
	}

	public void setAreaBz(String areaBz) {
		this.areaBz = areaBz;
	}

	@Column(name = "areaStatus")
	public String getAreaStatus() {
		return this.areaStatus;
	}

	public void setAreaStatus(String areaStatus) {
		this.areaStatus = areaStatus;
	}

	
	
	
	
	public void setUsrAreaBrandLinks(Set<UsrAreaBrandLink> usrAreaBrandLinks) {
		this.usrAreaBrandLinks = usrAreaBrandLinks;
	}

	public void setSupStores(Set<SupStore> supStores) {
		this.supStores = supStores;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supArea")
	public Set<UsrAreaBrandLink> getUsrAreaBrandLinks() {
		return this.usrAreaBrandLinks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supArea")
	public Set<SupStore> getSupStores() {
		return this.supStores;
	}

	

}
