package com.ocjp.extend;

class superClass{
	public float getNum() {return 3.0f;} 
}

class subclasses  extends superClass{
	
	 public float getNum() {return 4.0f; } 
	 //public void getNum() {} 
	 public void getNum (double d) { } 
	 public double getNum (float d) {return 4.0f; } 
}

	public class OverrideTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


