package com.ocjp.baseType;

public class BooleanTest {

	public void newVar(){
		int index = 1; 
		Boolean test = new Boolean(true); 
		//boolean foo= test[index]; 

	}
	
	
	 public Double   methodA(byte x, double y) {
		 return (short) x/y * 2; 
	}
	
	public static void main(String[] args) {

		// int index = 1;
		
		// boolean test = new Boolean();
		// boolean foo= test [index];

		BooleanTest test = new  BooleanTest();
		Double var = test.methodA((byte) 'b', 'a');
		System.out.println(var);
	}

}
