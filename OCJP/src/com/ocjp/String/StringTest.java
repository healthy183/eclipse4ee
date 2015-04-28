package com.ocjp.String;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

	
	public void operateWithoutStatic(StringBuffer x,StringBuffer y){
		//StringBuffer is can be modified content,
				//but memory address during calling other method
		x.append(y);  
		
		System.out.println(x);//CD
		y = x;
		
		System.out.println(y); //CD
		
		y.append("good");
	}
	
	public static void operate(StringBuffer x,StringBuffer y){
		x.append(y);
		y = x;
	}
	
	public void addList(List<String> strList){
		strList.add("str");
	}
	
	public void addInt(int i){
		i++;
	}
	
	public void testReplace(String text){
		//text = "java"; 
		String replaceStr = text.replace("i", "j"); 
		System.out.println(replaceStr);//java
		replaceStr =  text.replace("j", "i"); 
		System.out.println(replaceStr);//iava
		
		text =  text.replace("j", "i"); 
		
		System.out.println(text);//iava
	}
	
	
	public void initializedString(){
		String s;
		//无法打印 s未定义
		//System.out.println("s:"+s);
	}
	
	public static void main(String[] args) {
		
		
		StringBuffer a = new StringBuffer ("A"); 
		StringBuffer b = new StringBuffer ("B"); 
		
		//operate(a,b);
		//System.out.println(a+" "+b);
		
		StringBuffer c = new StringBuffer ("c"); 
		StringBuffer d = new StringBuffer ("d"); 
		
		StringTest stringTest = new StringTest();
		//stringTest.operateWithoutStatic(c, d);
		//System.out.println(c+" "+d); //cdgood d
		
		
		List<String> strList = new ArrayList<String>();
		stringTest.addList(strList);
		//System.out.println("size:"+strList.size());
		
		
		int ivar = 1;
		stringTest.addInt(ivar);
		//System.out.println("ivar:"+ivar); // 1
		String ja = "java";
		stringTest.testReplace(ja);
		
		System.out.println(ja);
		
	}

}
