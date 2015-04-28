package com.javaSE.statics;

class Parent{
	
	static {
		
		System.out.println("parent static space!");
		
	}
	
	{
		System.out.println("simple parent space");
	}
	
	Parent(){
		System.out.println("new parent!");
		
	}
	
}
 class Son extends Parent{
	
	 static {
			
			System.out.println("Son static space!");
			
		}
		
		{
			System.out.println("simple Son space");
		}
		
		Son(){
			System.out.println("new Son!");
			
		}
	 
	 
 }


public class StaticSpace {

	
			public static void main(String[] args) {
				
				new Son();
			}
	
	
	
}
