package com.ocjp.logicStr;

public class MathTest {

	
	public  static void doWhile(){
		
		int i= 1, j= 10;
		
		do {
			if (i++> --j) continue; 
		} while (i<5);
		
		System.out.println("i:"+i+" j:"+j);
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		int j = 1;
		 doWhile();
		//if(j = 1){}
		
		
	
		
	}
}
