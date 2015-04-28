package com.healthy.commons.mybean;

public class Customers {

	 private long id;
	 private String name;
	 private Addresss[] addresses;
	 
	 public Customers() {
		super();
	}

	public Customers(long id, String name, Addresss[] addresses) {
		super();
		this.id = id;
		this.name = name;
		this.addresses = addresses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Addresss[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresss[] addresses) {
		this.addresses = addresses;
	}

	
	 
	 
}
