package com.healthy.commons.lang;

import org.apache.commons.lang3.CharUtils;

public class CharUtilsUsage {

	
	public void toCharacterObject(){

		String charStr = "abc"; //return a
		System.out.println(CharUtils.toCharacterObject(charStr));
	}
	
	public void toChar(){
		
		String charStr = "abc";//return a
		System.out.println(CharUtils.toChar(charStr));
		
		System.out.println(CharUtils.toChar('a'));//return a
		
		System.out.println(CharUtils.toChar(charStr,'c'));//return a
	
		charStr = null;
		System.out.println(CharUtils.toChar(charStr,'c'));//return c
	}
	
	//null know function
	public void toIntValue(){
		//System.out.println(CharUtils.toIntValue('p'));
		System.out.println(CharUtils.toIntValue('p',2));
	}
	
	public void carToString(){
		System.out.println(CharUtils.toString('A'));
	}
	
	public void ismethod(){
		System.out.println(CharUtils.isAsciiAlpha('A'));
		System.out.println(CharUtils.isAsciiAlphaUpper('a'));
		System.out.println(CharUtils.isAsciiAlphaUpper('A'));
		System.out.println(CharUtils.isAsciiAlphaLower('a'));
		System.out.println(CharUtils.isAsciiAlphaLower('A'));
		
		System.out.println(CharUtils.isAsciiNumeric('1'));
		//System.out.println(CharUtils.isAsciiNumeric('11'));
		System.out.println(CharUtils.isAsciiAlphanumeric('a'));
	}
	
	
	public static void main(String[] args) {

		CharUtilsUsage charUtilsUsage = new CharUtilsUsage();
		charUtilsUsage.ismethod();
		//charUtilsUsage.carToString();
		//charUtilsUsage.toIntValue();
		//charUtilsUsage.toChar();
		//charUtilsUsage.toCharacterObject();
	}

}
