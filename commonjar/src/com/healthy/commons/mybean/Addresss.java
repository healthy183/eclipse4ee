package com.healthy.commons.mybean;

public class Addresss {

	private String zipCode;
    private String addr;
    private String city;
    private String country;
    
    
	public Addresss() {
		super();
	}

	public Addresss(String zipCode, String addr, String city, String country) {
		super();
		this.zipCode = zipCode;
		this.addr = addr;
		this.city = city;
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
    


}
