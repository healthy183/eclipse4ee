package com.healthy.commons.mybean;

public class Applicant {
	
	private String name;
    private int age;
    private String applyFor;
    
    
	public Applicant() {
		super();
	}


	public Applicant(String name, int age, String applyFor) {
		super();
		this.name = name;
		this.age = age;
		this.applyFor = applyFor;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getApplyFor() {
		return applyFor;
	}


	public void setApplyFor(String applyFor) {
		this.applyFor = applyFor;
	}


	@Override
	public String toString() {
		return "Applicant [name=" + name + ", age=" + age + ", applyFor="
				+ applyFor + "]";
	}

    
    

}
