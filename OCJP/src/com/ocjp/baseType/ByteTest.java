package com.ocjp.baseType;

public class ByteTest {
	 
	 public void  testBtype(){
		
		 byte array1, array2; 
		 byte array3; 
		 byte array4; 
		 
		 array1 = 1;
		 array2 = 2;
		 array3 = 3;
		 array4 = 4;
		 
		 array2 = array1;
		 array2 = array3;
	     array2 = array4;
	     
	     System.out.println(array2);
	 }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ByteTest b = new ByteTest();
		b.testBtype();
		/*
		 * 
		 * 	b.array1 = 1;
		b.array2 = 2;
		b.array3 = 3;
		b.array4 = 4;
		 * 
		//System.out.println( b.array1);
		
		 *
		 * 
		 * 
		b.array2 = b.array1; 
		b.array2 = b.array3; 
		b.array2 = b.array4;*/

	}

}
