package com.ocjp.operator;

public class MaybeTest {

	public static int j = 0;


	public boolean methodA(int num){
	
		j +=num;
		
		return true;
	}
	
	
	public void testMaybe(int i){
		
		boolean b = true;
		
		b = i<10 | methodA(4);
		System.out.println(b);
		
		b = i<10 | false;
		System.out.println(b);
		
		b = i<10 || methodA(8);
	}
	
	public void  testDownSign(){
	
		/*6求二进制过程*/
		/*6/2 = 3......0  6除以2得3余0*/
		/*3/2 = 1......1  3除以2得1余1*/
		/*1/2 = 0......1  3除以2得0余1*/
		
		System.out.println (6 ^ 3);//6的二进制系110  3的二进制系11
								   //比较         110
								   //		011
								   //结果	101(上下比较，同的0，不同得1)	
								   //二进制101右边读起，计算方法为:  1*2^0+0*2^1+1*2^2    --2^0嘅意思系2的0次方
	                            //                             1 + 0  + 4 = 5
	
		System.out.println (7 ^ 5);  //101
	}  
	
	public static void main(String[] args) {
		 
		MaybeTest maybeTest = new MaybeTest();
		maybeTest.testMaybe(12);
		System.out.println(j);
		
		
		//maybeTest.testDownSign();
		
		
	}

}
