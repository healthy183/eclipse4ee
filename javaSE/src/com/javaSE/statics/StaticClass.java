package com.javaSE.statics;

class Test{
	
	static int i = 1;
}


public class StaticClass {

	public void Test(){
		
		Test t =  new  Test();
		Test t2 =  new  Test();
		t.i++;
		System.out.println(t2.i);

		Test t3 =  new  Test();
		System.out.println(t3.i);
		System.out.println(t.i == t2.i);
	}
	public void Test2(){
		Test t =  new  Test();
		System.out.println(t.i);
	}
	
	
	
	public static void main(String[] args) {
		StaticClass s = new StaticClass();
		s.Test();
		s.Test2();
	}

}
