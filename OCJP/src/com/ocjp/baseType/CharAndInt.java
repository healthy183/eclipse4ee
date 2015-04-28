package com.ocjp.baseType;

public class CharAndInt {

	public void intMethod(int i){
		System.out.println(i);
	}
	
	
	public static void main(String[] args) {

		CharAndInt c = new CharAndInt();
		char chars = '2';
		c.intMethod(chars);
		
		chars = 'b';
		c.intMethod(chars);
		
		int i = chars +'c';
		System.out.println("i:"+i);
		
		i = chars +123;
		System.out.println("i:"+i);
		
	}

}
