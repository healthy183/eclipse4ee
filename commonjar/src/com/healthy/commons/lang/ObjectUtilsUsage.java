package com.healthy.commons.lang;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtilsUsage {

	
	public void defaultIfNull(){
		
		String defaultVar = ObjectUtils.defaultIfNull(null, "defaultValue");
		System.out.println(defaultVar);//defaultValue
		
		defaultVar = ObjectUtils.defaultIfNull("wfh", "defaultValue");
		System.out.println(defaultVar);//wfh
		
	}
	
	public void firstNonNull(){
		
		String array[] = {null,"a","b"};
		
		String defaultVar = ObjectUtils.firstNonNull(array);
		
		System.out.println(defaultVar);//a
		
	}
	
	public void equals(){
		
		boolean isEquals = ObjectUtils.equals(1, 1);
		System.out.println(isEquals);//true
		
		
		isEquals = ObjectUtils.equals(1, null);
		System.out.println(isEquals); //false
		
		isEquals = ObjectUtils.notEqual(1, 1);
		System.out.println(isEquals);//notEqual
		
		
		isEquals = ObjectUtils.notEqual(1, null);
		System.out.println(isEquals); //true
	}
	
	public void utilHashCode(){
		
		int hashCode = ObjectUtils.hashCode(null);
		System.out.println(hashCode);
		hashCode = ObjectUtils.hashCode("abc");
		System.out.println(hashCode);
	}

	//unknow function
	public void hashCodeMulti(){}
	//unknow function
	public void utilIdentityToString(){
		
		System.out.println(ObjectUtils.identityToString("abc"));
		System.out.println(ObjectUtils.identityToString(123));
		
	}
	
	public void utilToString(){
		
		System.out.println(ObjectUtils.toString("abc"));
		System.out.println(ObjectUtils.toString(null));
		System.out.println(ObjectUtils.toString(123));
		System.out.println(ObjectUtils.toString(null,"value"));
	}
	
	//unknow function 
	public void min(){
		int array[] ={1,6,2}; 
		//System.out.println(ObjectUtils.min(array));
	}
	
	public void compare(){
		
		int strA = 1;
		int strB = 2;
		int compareVar = ObjectUtils.compare(1, 2);
		System.out.println(compareVar);//-1
		
		compareVar = ObjectUtils.compare(2,1);
		System.out.println(compareVar);//1
		
		compareVar = ObjectUtils.compare(1,1);
		System.out.println(compareVar);//0
		
		String strC = "a";
		String strD = "b";
		//unknow function
		int compareVar2 = ObjectUtils.compare(strC, strD);
		System.out.println(compareVar);//0
		
		compareVar2 = ObjectUtils.compare(strD,strC);
		System.out.println(compareVar);//0
		
		compareVar2 = ObjectUtils.compare(strC,strC);
		System.out.println(compareVar);//0
	}
	//unknow function
	public void median(){
		int array[] ={1,6,2}; 
		//System.out.println(ObjectUtils.median(array));
	}
	
	//unknow function
	public void mode(){
		int array[] ={1,6,2}; 
		System.out.println(ObjectUtils.mode(array));
	}
	
	public void utilClone(){
		
		String val ="str"; //unknow function
		System.out.println(ObjectUtils.clone(val));
		
		CloneA a = new CloneA(1);
		
		CloneA  b = ObjectUtils.clone(a); //unknow function
		System.out.println(b != null ?b.getId():null);
		
		
		 b = ObjectUtils.cloneIfPossible(a);
		System.out.println(b != null ?b.getId():null);
	}
	
	public static void main(String[] args) {
		
		ObjectUtilsUsage objectUtilsUsage = new ObjectUtilsUsage();
		objectUtilsUsage.utilClone();
	}

}

class CloneA{
	
	private int id;

	public CloneA(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
