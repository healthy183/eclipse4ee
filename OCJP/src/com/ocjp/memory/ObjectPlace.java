package com.ocjp.memory;

public class ObjectPlace {


	public Object m() { 
		
		
		Object o = new Float(3.14F);
		Object[] oa = new Object[1];
		oa[0] = o;
		o = null;
		
		return oa[0];
	}
	
	
	public static void main(String[] args) {

		ObjectPlace obj = new ObjectPlace();
		System.out.println(obj.m());
		
	}

}
