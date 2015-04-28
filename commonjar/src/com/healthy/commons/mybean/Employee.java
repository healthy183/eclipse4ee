package com.healthy.commons.mybean;

import java.util.Date;

public class Employee {

	  private String name;
	    private int age;
	    private Date dateJoined;
	    private String grade;
	    private double salary;
	    
		public Employee() {
			super();
		}

		public Employee(String name, int age, Date dateJoined, String grade,
				double salary) {
			super();
			this.name = name;
			this.age = age;
			this.dateJoined = dateJoined;
			this.grade = grade;
			this.salary = salary;
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

		public Date getDateJoined() {
			return dateJoined;
		}

		public void setDateJoined(Date dateJoined) {
			this.dateJoined = dateJoined;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", dateJoined="
					+ dateJoined + ", grade=" + grade + ", salary=" + salary
					+ "]";
		}
		
		
	
}
