package com.healthy.commons.lang;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsUsage {

	
	public void random(){
		
	String random =	RandomStringUtils.random(1);
	System.out.println(random);
	
	random = RandomStringUtils.random(2);
	System.out.println(random);
	
	}
	
	public void randomAscii(){
		
		String randomAscii = RandomStringUtils.randomAscii(1);
		System.out.println(randomAscii);
		
		randomAscii = RandomStringUtils.randomAscii(2);
		System.out.println(randomAscii);
		
		}
	
	public void randomAlphabetic(){
		
		String random =	RandomStringUtils.randomAlphabetic(1);
		System.out.println(random);
		
		random = RandomStringUtils.randomAlphabetic(2);
		System.out.println(random);
		
	}
	
	public void randomNumeric(){
		
		String random =	RandomStringUtils.randomNumeric(1);
		System.out.println(random);
		
		random = RandomStringUtils.randomNumeric(2);
		System.out.println(random);
	}
	
	
	
	public static void main(String[] args) {
		
		RandomStringUtilsUsage randomStringUtilsUsage = new RandomStringUtilsUsage();
		randomStringUtilsUsage.randomNumeric();
	
		
		
	}

}
