package com.ocjp.baseType;

public class IntTest {

	public void doubleInt(){
		
		int i  =  0xFFFFFFF1; 
		int j = ~i; 
		
		//System.out.println(j);
		System.out.println("j等于：" + j + ",j二进制为：" + Integer.toBinaryString(j));
        System.out.println("i二进制为：" + Integer.toBinaryString(i));
		
		
	}
	
	public void newIntDouLongstack(){
		
		Integer i = new Integer(42); 
		Long lvalue = new Long(42); 
		Double d = new Double (42.0); 
		
		//System.out.println(i == lvalue);
		//System.out.println(i == d);
		//System.out.println(d == lvalue);
		
		System.out.println(i.equals(d));
		System.out.println(d.equals(i));
		System.out.println(i.equals(42));

	}

	public static void add(Integer i){
		
		int val = i.intValue();
		val += 3;
		i = new Integer(val);
		
	}
	
	public void intIndex(){
		
		//Question No: 6  page 5
	}
	
	
	public static void main(String[] args) {
		
		IntTest  t  = new IntTest();
		t.doubleInt();
		t.newIntDouLongstack();
		
		 Integer i = new Integer(0); 
		add(i); 
	 System.out.println(i.intValue());
	}

}
