package com.kang.model;

// Generated 2012-12-26 9:59:48 by Hibernate Tools 4.0.0

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StorePluLink generated by hbm2java
 */
@Entity
@Table(name = "store_Plu_link", schema = "dbo", catalog = "supCRM")
public class StorePluLink implements java.io.Serializable {

	private int mxId;
	private SupPlu supPlu;
	private SupStore supStore;
	private Integer saleQty;
	private Double saleAmt;
	private Integer memQty;
	private Double menAmt;
	private Integer stockQty;
	private Integer couQty;
	private Date saleDate;
	private String linkBz;

	public StorePluLink() {
	}

	public StorePluLink(int mxId) {
		this.mxId = mxId;
	}

	public StorePluLink(int mxId, SupPlu supPlu, SupStore supStore,
			Integer saleQty, Double saleAmt, Integer memQty, Double menAmt,
			Integer stockQty, Integer couQty, Date saleDate, String linkBz) {
		this.mxId = mxId;
		this.supPlu = supPlu;
		this.supStore = supStore;
		this.saleQty = saleQty;
		this.saleAmt = saleAmt;
		this.memQty = memQty;
		this.menAmt = menAmt;
		this.stockQty = stockQty;
		this.couQty = couQty;
		this.saleDate = saleDate;
		this.linkBz = linkBz;
	}

	@Id
	@Column(name = "mxID", unique = true, nullable = false)
	public int getMxId() {
		return this.mxId;
	}

	public void setMxId(int mxId) {
		this.mxId = mxId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pluId")
	public SupPlu getSupPlu() {
		return this.supPlu;
	}

	public void setSupPlu(SupPlu supPlu) {
		this.supPlu = supPlu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	public SupStore getSupStore() {
		return this.supStore;
	}

	public void setSupStore(SupStore supStore) {
		this.supStore = supStore;
	}

	@Column(name = "saleQty")
	public Integer getSaleQty() {
		return this.saleQty;
	}

	public void setSaleQty(Integer saleQty) {
		this.saleQty = saleQty;
	}

	@Column(name = "saleAmt", precision = 53, scale = 0)
	public Double getSaleAmt() {
		return this.saleAmt;
	}

	public void setSaleAmt(Double saleAmt) {
		this.saleAmt = saleAmt;
	}

	@Column(name = "memQty")
	public Integer getMemQty() {
		return this.memQty;
	}

	public void setMemQty(Integer memQty) {
		this.memQty = memQty;
	}

	@Column(name = "menAmt", precision = 53, scale = 0)
	public Double getMenAmt() {
		return this.menAmt;
	}

	public void setMenAmt(Double menAmt) {
		this.menAmt = menAmt;
	}

	@Column(name = "stockQty")
	public Integer getStockQty() {
		return this.stockQty;
	}

	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}

	@Column(name = "couQty")
	public Integer getCouQty() {
		return this.couQty;
	}

	public void setCouQty(Integer couQty) {
		this.couQty = couQty;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "saleDate", length = 23)
	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Column(name = "linkBZ")
	public String getLinkBz() {
		return this.linkBz;
	}

	public void setLinkBz(String linkBz) {
		this.linkBz = linkBz;
	}

}
