package com.ocjp.extend;

 class SuperClassC{
	 
	public int i = 0;

	 public SuperClassC(String text){
		i = 1;
	 }
 } 
class SubclassC extends  SuperClassC {
	

	
	public SubclassC(String text){
	    super(text);
	    i = 2;
	 }/**/
}


public class ConstructortTest {
	
	public  Object m(){

		Object o = new Float(3.14F); 
		
		Object oa = new Object[1]; 
		
		oa= o; 
		
		o = null; 
		
		return oa; 
	}
	
	
	public static void main(String[] args) {

		SubclassC  c = new SubclassC("S");
		System.out.println(c.i);
		
		ConstructortTest cs = new ConstructortTest();
		System.out.println( cs.m() );//3.14
		
	}

}
