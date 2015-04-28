package com.healthy.commons.lang;

import org.apache.commons.lang3.BooleanUtils;

public class BooleanUtilsUsage {

	
	
	public void negate(){
		                                 //negate 否定
		Boolean bool = new Boolean(true);//if null return null
		System.out.println(BooleanUtils.negate(bool));
		
		System.out.println(BooleanUtils.negate(null));
	}
	
	public void isTrue(){
		
		Boolean bool = new Boolean(true);
		System.out.println(BooleanUtils.isTrue(bool));
		//if null return false
		System.out.println(BooleanUtils.isTrue(null));
	}
	
	public void isNotTrue(){
		
		Boolean bool = new Boolean(true);
		System.out.println(BooleanUtils.isNotTrue(bool));
		//if null return true
		System.out.println(BooleanUtils.isNotTrue(null));
		
	}
	
	public void isFalse(){
		
		Boolean bool = new Boolean(true);
		System.out.println(BooleanUtils.isFalse(bool));
		//if null return false
		System.out.println(BooleanUtils.isFalse(null));
	
	}
	
	public void isNotFalse(){
		
		Boolean bool = new Boolean(true);
		System.out.println(BooleanUtils.isNotFalse(bool));
		//if null return true
		System.out.println(BooleanUtils.isNotFalse(null));
	}
	
	public void toBooleanObject(){
		
		boolean bool = true;
		System.out.println(BooleanUtils.toBooleanObject(1));
		
	}
	
	public void toBoolean(){
		Boolean bool = new Boolean(true);
		System.out.println(BooleanUtils.toBoolean(bool));

		System.out.println(BooleanUtils.toBoolean("No"));
	
	}
	
	public void toBooleanDefaultIfNull(){
		
		Boolean bool = new Boolean(true);
		System.out.println(BooleanUtils.toBooleanDefaultIfNull(bool, true));
		
		System.out.println(BooleanUtils.toBooleanDefaultIfNull(null, false));
		
	}
	
	public void toBooleanWithInt(){
		 //return boolean  value != 0 
		System.out.println(BooleanUtils.toBoolean(0));
		System.out.println(BooleanUtils.toBoolean(1));
	}
	
	public void toBooleanWithInteger(){
		 //return Boolean value != 0 
		System.out.println(BooleanUtils.toBooleanObject(0));
		System.out.println(BooleanUtils.toBooleanObject(1));
		
	}
	
	public void toBooleanObjectWithInteger(){
		
		Integer intObject = null;
		System.out.println(BooleanUtils.toBooleanObject(new Integer(0)));
		System.out.println(BooleanUtils.toBooleanObject(new Integer(1)));
		System.out.println(BooleanUtils.toBooleanObject(intObject));
		
		
	}
	
	public void treblingToBoolean(){
		
		System.out.println(BooleanUtils.toBoolean(1,1,2));
		System.out.println(BooleanUtils.toBoolean(1,2,1));
		System.out.println(BooleanUtils.toBoolean(1,2,null));
		
	}
	
	public void treblingToBooleanObject(){
		
		System.out.println(BooleanUtils.toBoolean(new Integer(1),new Integer(1),new Integer(2)));
		System.out.println(BooleanUtils.toBoolean(new Integer(1),new Integer(2),new Integer(1)));
		
		//System.out.println(BooleanUtils.toBoolean(null,new Integer(2),new Integer(1)));//exeception
		//System.out.println(BooleanUtils.toBoolean(new Integer(1),null,null));//execetpion
		System.out.println(BooleanUtils.toBoolean(null,new Integer(2),null));//false
		//System.out.println(BooleanUtils.toBoolean(null,null,new Integer(1)));//true
		
	}
	
	public void booleanToInt(){
		System.out.println(BooleanUtils.toInteger(true));
	}
	
	public void booleanToInteger(){
		System.out.println(BooleanUtils.toIntegerObject(true));
		System.out.println(BooleanUtils.toIntegerObject(new Boolean(false)));
		System.out.println(BooleanUtils.toIntegerObject(new Boolean(null)));
	}
	
	public void toInteger(){
		
		System.out.println(BooleanUtils.toInteger(true, 2, 3));
		System.out.println(BooleanUtils.toInteger(new Boolean(false), 2, 3,4));
		System.out.println(BooleanUtils.toInteger(null, 2, 3,4));
	}
	
	public void toBooleanObjectByString(){
		
		String trueStr = "true";
		String falseStr = "false";
		String onStr = "On";
		String offStr = "Off";
		String yesStr = "yes";
		String noStr = "No";
		
		System.out.println(BooleanUtils.toBooleanObject(trueStr));
		System.out.println(BooleanUtils.toBooleanObject(falseStr));
		System.out.println(BooleanUtils.toBooleanObject(onStr));
		System.out.println(BooleanUtils.toBooleanObject(offStr));
		System.out.println(BooleanUtils.toBooleanObject(yesStr));
		System.out.println(BooleanUtils.toBooleanObject(noStr));
		System.out.println(BooleanUtils.toBooleanObject(new String("")));
	
		System.out.println(BooleanUtils.toBoolean(trueStr,trueStr,falseStr));
	
	}
	
	public void booleantoString(){
		System.out.println(BooleanUtils.toStringTrueFalse(true));
		System.out.println(BooleanUtils.toStringOnOff(false));
		System.out.println(BooleanUtils.toStringYesNo(false));
		System.out.println(BooleanUtils.toString(false,"yes","no"));
	}
	
	public void xor(){
		
		boolean array[] = {false,false,true};
		System.out.println(BooleanUtils.xor(array));
	}
	
	public void xortoPrimitive(){
		
		Boolean array[] = {true,false,true};
		System.out.println(BooleanUtils.xor(array));
	}
	
	public static void main(String[] args) {

		BooleanUtilsUsage booleanUtilsUsage = new BooleanUtilsUsage();
		//booleanUtilsUsage.xor();
		//booleanUtilsUsage.negate();
		//booleanUtilsUsage.isTrue();
		//booleanUtilsUsage.isNotTrue();
		//booleanUtilsUsage.isFalse();
		//booleanUtilsUsage.isNotFalse();
		//booleanUtilsUsage.toBooleanObject();
		booleanUtilsUsage.toBoolean();
		//booleanUtilsUsage.toBooleanDefaultIfNull();
		//booleanUtilsUsage.toBooleanWithInt();
		//booleanUtilsUsage.toBooleanWithInteger();
		//booleanUtilsUsage.toBooleanObjectWithInteger();
		//booleanUtilsUsage.treblingToBoolean();
		//booleanUtilsUsage.treblingToBooleanObject();
		//booleanUtilsUsage.booleanToInt();
		//booleanUtilsUsage.booleanToInteger();
		//booleanUtilsUsage.toInteger();
		//booleanUtilsUsage.toBooleanObjectByString();
		//booleanUtilsUsage.booleantoString();
	}

}
