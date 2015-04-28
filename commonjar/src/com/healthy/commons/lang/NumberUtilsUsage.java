package com.healthy.commons.lang;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberUtilsUsage {

	public void toInt(){
		
		System.out.println(NumberUtils.toInt("1"));
		System.out.println(NumberUtils.toInt("a",2));
	}
	
	public void toLong(){
		System.out.println(NumberUtils.toLong("1"));
		System.out.println(NumberUtils.toLong("a",2));
	}
	
	public void toFloat(){
		System.out.println(NumberUtils.toFloat("1.1"));
		System.out.println(NumberUtils.toFloat("a",2));
	}
	
	public void toDouble(){
		System.out.println(NumberUtils.toDouble("1.1"));
		System.out.println(NumberUtils.toDouble("a",2));
	}
	
	public void toByte(){
		System.out.println(NumberUtils.toByte("1.1"));
		byte bytea = 1;
		System.out.println(NumberUtils.toByte("a",bytea));
	
	}
	
	public void toShort(){
		System.out.println(NumberUtils.toShort("1.1"));
		short bytea = 1;
		System.out.println(NumberUtils.toShort("a",bytea));
	
	}
	
	public void isAllZeros(){
		System.out.println();
	}
	
	public void createNumber(){
		System.out.println(NumberUtils.createFloat("1.2"));
		System.out.println(NumberUtils.createDouble("1.2"));
		//System.out.println(NumberUtils.createInteger("1.2"));
		//System.out.println(NumberUtils.createLong("1.2"));
		System.out.println(NumberUtils.createInteger("1"));
		System.out.println(NumberUtils.createLong("1"));
		//System.out.println(NumberUtils.createBigInteger("1.2"));
		System.out.println(NumberUtils.createBigDecimal("1.2"));

	}
	
	public void min(){
		
		long longArray[] = {1,2,3};
		System.out.println(NumberUtils.min(longArray));
		System.out.println(NumberUtils.max(longArray));
	}
	
	public void isNumber(){
		System.out.println(NumberUtils.isNumber("ad"));
	}
	
	
	public static void main(String[] args) {
		
		NumberUtilsUsage numberUtilsUsage = new NumberUtilsUsage();
		numberUtilsUsage.isNumber();
		//numberUtilsUsage.min();
		//numberUtilsUsage.createNumber();
		//numberUtilsUsage.toShort();
		//numberUtilsUsage.toByte();
		//numberUtilsUsage.toDouble();
		//numberUtilsUsage.toFloat();
		//numberUtilsUsage.toLong();
		//numberUtilsUsage.toInt();
	}

}
