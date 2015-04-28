package com.healthy.commons.mybean;

public class Book {

	private String name;
	private String isbn;
	private double retailPrice;

	public Book() {
		super();
	}

	public Book(String name, String isbn, double retailPrice) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.retailPrice = retailPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

}
