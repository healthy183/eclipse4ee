package com.ocjp.extend;

public class OverloadTest {

	 public void setVar (int a, int b, float c) {  } 
		

	/*	*/
	//private void setVar (int a, float c, int b){}; 
	//protected void setVar (int a, int b, float c){}; 

	
	public int setVar(int a, float c, int b){return a;};  
	//public int setVar (int a, int b, float c) {return a;};  
	
	//protected float setVar (int a, int b, float c) {return c;}; 
	
}
