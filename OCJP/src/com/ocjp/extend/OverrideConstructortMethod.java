package com.ocjp.extend;


class TestClass{
	
	private int intVal;
	private String strVar;
	
	protected TestClass(String strVar) {
		this.strVar = strVar;
	}
	private TestClass() {
	}
	
	TestClass(int intVal) {
		this.intVal = intVal;
	}
	
	public TestClass(int intVal, String strVar) {
		super();
		this.intVal = intVal;
		this.strVar = strVar;
	}
	public int getIntVal() {
		return intVal;
	}
	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}
	public String getStrVar() {
		return strVar;
	}
	public void setStrVar(String strVar) {
		this.strVar = strVar;
	}
}

public class OverrideConstructortMethod {
	
	public static void main(String[] args) {
		
		//TestClass testClass = new TestClass();
		TestClass testClass = new TestClass(1);
		TestClass testClass2 = new TestClass("str");
		TestClass testClass3 = new TestClass(1,"str");
	}

}
