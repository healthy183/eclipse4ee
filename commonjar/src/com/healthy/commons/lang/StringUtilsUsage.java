package com.healthy.commons.lang;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtilsUsage {
	
	public void isEmpty(){
		
		System.out.println(StringUtils.isEmpty(null)); //true
		System.out.println(StringUtils.isEmpty("")); //true
		System.out.println(StringUtils.isEmpty(" "));//false
		System.out.println(StringUtils.isEmpty("wfh"));//false
	}
	
	
	public void isBlank(){
		
		System.out.println(StringUtils.isBlank(null)); //true
		System.out.println(StringUtils.isBlank(""));//true
		System.out.println(StringUtils.isBlank("  "));//true
		System.out.println(StringUtils.isBlank("wfh"));//false
		System.out.println(StringUtils.isBlank(" n "));//false
	
	}
	
	public void trim(){
		System.out.println(StringUtils.trim(null)); //null
		System.out.println(StringUtils.trim("").equals("")); //"" true
		System.out.println(StringUtils.trim(" ").equals(""));//""  true
		System.out.println(StringUtils.trim(" a "));//"a"
	}
	
	public void trimToNull(){
		
		System.out.println(StringUtils.trimToNull("")==null);//null true
		System.out.println(StringUtils.trimToNull(" ")==null);//null true
		System.out.println(StringUtils.trimToNull(null)== null);//null  true
		System.out.println(StringUtils.trimToNull(" a "));//a
	}
	
	public void trimToEmpty(){
		
		System.out.println(StringUtils.trimToEmpty(null).equals(""));//""  true
		System.out.println(StringUtils.trimToEmpty("").equals(""));//""  true
		System.out.println(StringUtils.trimToEmpty(" ").equals(""));//""  true
		System.out.println(StringUtils.trimToEmpty(" a "));//a
	}
	//remove between two side
	public void strip(){
		
		System.out.println(StringUtils.strip("abc", "a"));  //return bc
		System.out.println(StringUtils.strip("abc", "b"));  //return abc
		System.out.println(StringUtils.strip("abc", "c"));  //return ab
		System.out.println(StringUtils.strip("abca", "a")); //return bc
		System.out.println(StringUtils.strip("abc",null)); //return abc
		System.out.println(StringUtils.strip("",null).equals(""));//"" return true
	}
	
	//after trim then if "" return null
	public void stripToNull(){
		
		System.out.println(StringUtils.stripToNull(null));   //null
		System.out.println(StringUtils.stripToNull(""));   //null
		System.out.println(StringUtils.stripToNull(" "));   //null
		System.out.println(StringUtils.stripToNull("abc"));   //abc
		System.out.println(StringUtils.stripToNull(" abc "));   //abc

	}
	
	//after trim then if ("" or null) return null
	public void stripToEmpty(){
		
		System.out.println(StringUtils.stripToEmpty(null).equals(""));   //"" true
		System.out.println(StringUtils.stripToEmpty("").equals(""));   //"" true
		System.out.println(StringUtils.stripToEmpty(" ").equals(""));   //"" true
		System.out.println(StringUtils.stripToEmpty("abc"));   //abc
		System.out.println(StringUtils.stripToEmpty(" abc "));   //abc
	}
	
	//remove start side
	public void stripStart(){
		System.out.println(StringUtils.stripStart("abca", "a"));  //return bca
		System.out.println(StringUtils.stripStart("abca", "ab"));  //return ca
	}
	//remove end side
	public void stripEnd(){
		System.out.println(StringUtils.stripEnd("abca", "a"));  //return abc
		System.out.println(StringUtils.stripEnd("abca", "ca"));  //return ab

	}
	//stripAll between two side
	public void stripAll(){
		
		String strArray[] = {"abc","adfa","cda"}; //return bc df cd 
		System.out.println(ArrayUtils.toString(StringUtils.stripAll(strArray, "a")));  
		
	}
	
	public void utilsEquals(){
		
		System.out.println(StringUtils.equals("abca", "a"));  //false
		System.out.println(StringUtils.equals("a", "a"));  //true
		System.out.println(StringUtils.equals(null, "a"));  //false
		System.out.println(StringUtils.equals(null, null));  //true
		System.out.println(StringUtils.equals("a",null));  //false
	}
	
	public void utilsEqualsIgnoreCase(){
		
		System.out.println(StringUtils.equalsIgnoreCase("abca", "a"));  //false
		System.out.println(StringUtils.equalsIgnoreCase("a", "A"));  //true
		System.out.println(StringUtils.equalsIgnoreCase(null, "a"));  //false
		System.out.println(StringUtils.equalsIgnoreCase(null, null));  //true
		System.out.println(StringUtils.equalsIgnoreCase("a",null));  //false
	}
	
	public void indexOf(){
		System.out.println(StringUtils.indexOf("abca", "a"));//0  
		System.out.println(StringUtils.indexOf("abca", 'b'));//1  
		System.out.println(StringUtils.indexOf(null, 'b'));//-1  
		System.out.println(StringUtils.indexOf("", 'b'));//-1
		System.out.println(StringUtils.indexOf("abcda","a",2));//4
		System.out.println(StringUtils.indexOf("abcda","a",6));//-1
		System.out.println(StringUtils.indexOf("abcda","",5));//5
	}
	
	//dont know how to use
	public void ordinalIndexOf(){
		System.out.println(StringUtils.ordinalIndexOf("aabca", "a",1));  
	}
	
	public void lastIndexOf(){
		
		System.out.println(StringUtils.lastIndexOf("abcb", 'b'));//3
		//unknow function
		System.out.println(StringUtils.lastIndexOf("abcb", 'b',0));//-1
		System.out.println(StringUtils.lastIndexOf("abcb", 'b',1));//1
		System.out.println(StringUtils.lastIndexOf("abcb", 'b',2));	//1
		System.out.println(StringUtils.lastIndexOf("abcb", 'b',3));//3
		System.out.println(StringUtils.lastIndexOf("abcb", 'b',4));//3
	}
	
	public void indexOfIgnoreCase(){
		System.out.println(StringUtils.indexOfIgnoreCase("abcb", "B"));
		//unknow function
		System.out.println(StringUtils.indexOfIgnoreCase("abcb", "B",1));//return 1
		System.out.println(StringUtils.indexOfIgnoreCase("abcb", "B",2));//return 3
	}
	
	
	public void contains(){
	
		System.out.println(StringUtils.contains("abcb", 'b'));//true
		System.out.println(StringUtils.contains("abcb", "e"));//false
		System.out.println(StringUtils.containsIgnoreCase("abcb", "e"));//false
		System.out.println(StringUtils.containsIgnoreCase("abcb", "A"));//true
	}
	
	public void containsWhitespace(){
		
		System.out.println(StringUtils.containsWhitespace("ab cb"));//true
		System.out.println(StringUtils.containsWhitespace("abcb"));//false
	}
	
	public void containsAny(){
		
		char array[] = {'b','a'};
		System.out.println(StringUtils.containsAny("aed",array));//0
		System.out.println(StringUtils.containsAny("e",array));//-1
	}
	
	
	public void indexOfAny(){
		
		char array[] = {'b','a'};
		System.out.println(StringUtils.indexOfAny("abcb",array));//0

		System.out.println(StringUtils.indexOfAny("abcb","b"));//1
		
		String[] strArray = {"c","b"};
		System.out.println(StringUtils.indexOfAny("aeb",strArray));//2
		
	}
	//unknow function
	public void indexOfAnyBut(){
		
		char array[] = {'b','a'};
		System.out.println(StringUtils.indexOfAnyBut("abcb",array));
		
		System.out.println(StringUtils.indexOfAnyBut("abcb","be"));
		
		System.out.println(StringUtils.indexOfAnyBut("abcb","e"));
	}
	//unknow function
	public void containsOnly(){
		
		char array[] = {'b','a'};
		System.out.println(StringUtils.containsOnly("abcb",array));
		
		char arrayE[] = {'e'};
		System.out.println(StringUtils.containsOnly("abcb",arrayE));
		
		char arrayA[] = {'a'};
		System.out.println(StringUtils.containsOnly("abcb",arrayA));
		
		char arrayB[] = {'a','c'};
		System.out.println(StringUtils.containsOnly("abcb",arrayA));
	}
	
	public void containsNone(){
		
		char array[] = {'b','a'};
		System.out.println(StringUtils.containsNone("abcb",array));//false
		
		char arrayA[] = {'e','f'};
		System.out.println(StringUtils.containsNone("abcb",arrayA));//true
		
		char arrayB[] = {'e','a'};
		System.out.println(StringUtils.containsNone("abcb",arrayB));//false

	}
	
	public void lastIndexOfAny(){
		
		String[] strArray  = {"a","b"};
		
		System.out.println(StringUtils.lastIndexOfAny("abc", strArray));
	}
	
	public void substring(){
		
		System.out.println(StringUtils.substring("abc",-1));//c
		
		System.out.println(StringUtils.substring("abc",1));//bc
		
		System.out.println(StringUtils.substring("abc",1,2));//b
		
		System.out.println(StringUtils.substring("abc",-1,2));//""
		
		System.out.println(StringUtils.left("abcd",2));//ab
		
		System.out.println(StringUtils.right("abcd",2));//cd
		
		System.out.println(StringUtils.mid("abcd",1,2));//bc
		
		System.out.println(StringUtils.substringBefore("abcd","bc"));//a
		
		System.out.println(StringUtils.substringBefore("abcdbc","bc"));//a
		
		System.out.println(StringUtils.substringAfter("abcd","bc"));//d
		
	
		System.out.println(StringUtils.substringBeforeLast("abcdbc","bc"));//abcd
		
		System.out.println(StringUtils.substringAfterLast("abcd","ac"));//""
	
		System.out.println(StringUtils.substringBetween("abc","ac"));//null
		System.out.println("===");
		System.out.println(StringUtils.substringBetween("bacd","ac"));//null
		
		System.out.println(StringUtils.substringBetween("abc","a","c"));//b
		
		System.out.println( ArrayUtils.toString( //b,d
				StringUtils.substringsBetween("abcadc","a","c")));
	}
	
	public void split(){
		
		System.out.println(ArrayUtils.toString(StringUtils.split("a b c")));//{a,b,c}
	
		System.out.println(ArrayUtils.toString(StringUtils.split("abaca","a")));//{b,c}
		
		System.out.println(ArrayUtils.toString(StringUtils.split("abaca",'a')));//{b,c}
		//unknow function 
		System.out.println(ArrayUtils.toString(StringUtils.splitByWholeSeparator("abaca","a")));//{b,c,}
		
		System.out.println(ArrayUtils.toString(StringUtils.splitByWholeSeparator("a ba ca","a")));//{ b, c,}

		System.out.println(ArrayUtils.toString(StringUtils.splitByWholeSeparator("abaca","a",2)));//{b,ca}
		
		System.out.println(ArrayUtils.toString(StringUtils.splitByWholeSeparator("abaca","a",0)));//{b,c,}
		
		System.out.println(ArrayUtils.toString(StringUtils.splitByWholeSeparator("ababa","b",3)));//{a,a,a}
		
		System.out.println(ArrayUtils.toString( 
				StringUtils.splitByWholeSeparatorPreserveAllTokens("ababa","b",3)));//{a,a,a}
		
		System.out.println(ArrayUtils.toString( 
				StringUtils.splitByWholeSeparatorPreserveAllTokens("ababa","b",2)));//{a,aba}
		
		//System.out.println(ArrayUtils.toString( 
		//		StringUtils.splitByWholeSeparatorWorker("ababa","b",2,true)));//{a,aba}
	}
	
	public void splitPreserveAllTokens(){
		
		System.out.println(ArrayUtils.toString
				(StringUtils.splitPreserveAllTokens("a b a c a")));//{a,b,a,c,a}
	
		System.out.println(ArrayUtils.toString(
				StringUtils.splitPreserveAllTokens("a b a c a",'a')));	//{, b , c ,}
		
		System.out.println(ArrayUtils.toString(
				StringUtils.splitByCharacterType("a b a c a")));//{a, ,b, ,a, ,c, ,a}
		
		System.out.println(ArrayUtils.toString
				(StringUtils.splitByCharacterTypeCamelCase("a b a c a")));//{a, ,b, ,a, ,c, ,a}
		
		System.out.println(ArrayUtils.toString(
				StringUtils.splitByCharacterTypeCamelCase("a b a c a")));//{a, ,b, ,a, ,c, ,a}
	}
	
	//unkonw function
	public void join(){
		
		String[] strArray = {"a","b","d"};
		//System.out.println(StringUtils.join(strArray));
		
		//System.out.println(StringUtils.join(strArray,'c'));
		
		System.out.println(StringUtils.join(strArray,'c',1,2));//b
		
		System.out.println(StringUtils.join(strArray,"c"));//acbcd
		
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("efg");
		
		System.out.println(StringUtils.join(list.iterator(),"c"));//abccefg
	}
	
	public void deleteWhitespace(){
		
		String abc = "a b c";
		System.out.println(StringUtils.deleteWhitespace(abc)); //return abc
		
		String removeStr = "abcd";
		System.out.println(StringUtils.removeStart(removeStr, "ab")); //return cd
		
		System.out.println(StringUtils.removeStartIgnoreCase("abcd", "aB"));// return  cd;
		
		System.out.println(StringUtils.removeEnd(removeStr, "c"));//abcd
		
		System.out.println(StringUtils.removeEndIgnoreCase("abcd", "D"));//abc
	
	}
	
	public void remove(){
		
		System.out.println(StringUtils.remove("abcdc", "c"));//abd
	}
	
	public void replace(){
		
		System.out.println(StringUtils.replaceOnce("abca","a","d"));//dbca
		
		System.out.println(StringUtils.replace("abca","a","d"));//dbcd
		
		System.out.println(StringUtils.replace("abca","a","d",-1));//replace all
		
		System.out.println(StringUtils.replace("abca","a","d",0)); //abca
		
		System.out.println(StringUtils.replace("abca","a","d",1));//dbca
		
		System.out.println(StringUtils.replace("abca","a","d",2));//dbcd

		System.out.println(StringUtils.replaceChars("abca",'a','d'));//dbcd
		
		System.out.println(StringUtils.replaceChars("abca","a","d"));//dbcd
	}
	//unknow function 
	public void overlay(){
		
		System.out.println(StringUtils.overlay("abc", "d", 0, 3));
	
		System.out.println(StringUtils.chomp("abc"));
		
		System.out.println(StringUtils.chomp("abc","d"));
		
		System.out.println(StringUtils.chop("abc"));
	}
	
	//unknow function 
	public void repeat(){
		
		System.out.println(StringUtils.repeat("abcc",1));
		
	}
	//unknow function 
	public void padding(){
		//System.out.println(StringUtils.padding(0,'a'));
	}
	
	public void rightPad(){
	
	    //add char 'b' until string.length>6 
		String rigthStr = "abc";
		System.out.println(StringUtils.rightPad(rigthStr,6,'b'));
		//system out abcbbb
		
		System.out.println(StringUtils.rightPad(rigthStr,6,"ef"));
	    //system out abcefe
	}
	
	public void leftPad(){
	
		String rigthStr = "abc";
		System.out.println(StringUtils.leftPad(rigthStr,6,'b'));
		//system out abcbbb
		System.out.println(StringUtils.leftPad(rigthStr,6,"ef"));
	}
	
	
		public void center(){
	
		String rigthStr = "abc";
		System.out.println(org.apache.commons.lang3.StringUtils.center(rigthStr,6,'b'));
		//system out babcbb
		System.out.println(org.apache.commons.lang3.StringUtils.center(rigthStr,6,"ef"));
		//system out eabcef
	}
	
	public void upperCase(){
	
		String rigthStr = "abc";
		System.out.println(org.apache.commons.lang3.StringUtils.upperCase(rigthStr));
		
	}
	
	public void lowerCase(){
		String rigthStr = "ABC";
		System.out.println(org.apache.commons.lang3.StringUtils.lowerCase(rigthStr));
	}
	
	public void capitalize(){//unknow  function
		String rigthStr = "AbC";
		System.out.println(org.apache.commons.lang3.StringUtils.capitalize(rigthStr));
	}
	
	public void uncapitalize(){//unknow  function
		String rigthStr = "AbC";
		System.out.println(org.apache.commons.lang3.StringUtils.uncapitalize(rigthStr));
	}
	
	public void swapCase(){
		
		String rigthStr = "AbC";//return aBc
		System.out.println(org.apache.commons.lang3.StringUtils.swapCase(rigthStr));
	}
	
	public void countMatches(){
		
		String rigthStr = "3Ab1C2";
		String rigthStr2 = "3Ab1C2";
		String rigthStr3 = "abc"; //unknow  function  
		System.out.println(org.apache.commons.lang3.StringUtils.countMatches(rigthStr,rigthStr2));
		System.out.println(org.apache.commons.lang3.StringUtils.countMatches(rigthStr,rigthStr3));
		//return 1 return 0	
	}
	
	public void isAlpha(){//unknow  function
		
		String rigthStr2 = "3Ab1C2";
		String rigthStr3 = "3Ab1C 2";
		System.out.println(org.apache.commons.lang3.StringUtils.isAlpha(rigthStr2));
		System.out.println(org.apache.commons.lang3.StringUtils.isAlpha(rigthStr3));
		
		System.out.println(org.apache.commons.lang3.StringUtils.isAlphaSpace(rigthStr2));
		System.out.println(org.apache.commons.lang3.StringUtils.isAlphaSpace(rigthStr3));
		
		System.out.println(org.apache.commons.lang3.StringUtils.isAlphanumeric(rigthStr2));
		System.out.println(org.apache.commons.lang3.StringUtils.isAlphanumeric(rigthStr3));
		
	}
	
	public void isNumeric(){
		
		String rigthStr = "123";
		String rigthStr2 = "3Ab1C2";
		String rigthStr3 = "3Ab1C 2";
		String rigthStr4 = "3 1 2";
		
		System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(rigthStr));//true
		System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(rigthStr2));//false
		System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(rigthStr3));//false
		System.out.println(org.apache.commons.lang3.StringUtils.isNumeric(rigthStr4));//false

		
		System.out.println(org.apache.commons.lang3.StringUtils.isNumericSpace(rigthStr));//true
		System.out.println(org.apache.commons.lang3.StringUtils.isNumericSpace(rigthStr2));//false
		System.out.println(org.apache.commons.lang3.StringUtils.isNumericSpace(rigthStr3));//false
		System.out.println(org.apache.commons.lang3.StringUtils.isNumericSpace(rigthStr4));//true
	}
	
	public void isWhitespace(){
		
		String strSpace = "";
		String strSpace2 = " ";
		String strSpace3 = " a ";
		
		System.out.println(org.apache.commons.lang3.StringUtils.isWhitespace(null));//false
		System.out.println(org.apache.commons.lang3.StringUtils.isWhitespace(strSpace));//true
		System.out.println(org.apache.commons.lang3.StringUtils.isWhitespace(strSpace2));//true
		System.out.println(org.apache.commons.lang3.StringUtils.isWhitespace(strSpace3));//false;
	}
	
	public void isAllLowerCase(){
		
		String strSpace = "";
		String strSpace2 = " aB ";
		String strSpace3 = " ab ";
		String strSpace4 = "ab";
		
		System.out.println(org.apache.commons.lang3.StringUtils.isAllLowerCase(strSpace));
		System.out.println(org.apache.commons.lang3.StringUtils.isAllLowerCase(strSpace2));
		System.out.println(org.apache.commons.lang3.StringUtils.isAllLowerCase(strSpace3));
		System.out.println(org.apache.commons.lang3.StringUtils.isAllLowerCase(strSpace4));

		
	}
	
	
	public void isAllUpperCase(){
		
		String strSpace = "";
		String strSpace2 = " aB ";
		String strSpace3 = " AB ";
		String strSpace4 = "AB";
		
		System.out.println(org.apache.commons.lang3.StringUtils.isAllUpperCase(strSpace));
		System.out.println(org.apache.commons.lang3.StringUtils.isAllUpperCase(strSpace2));
		System.out.println(org.apache.commons.lang3.StringUtils.isAllUpperCase(strSpace3));
		System.out.println(org.apache.commons.lang3.StringUtils.isAllUpperCase(strSpace4));
	}
	
	public void defaultString(){
		
		String defaultValue = null;
		String defaultspace = "";
		String defaultspace2 = " ";
		
		System.out.println(org.apache.commons.lang3.StringUtils.defaultString(null).equals(""));//true
		System.out.println(org.apache.commons.lang3.StringUtils.defaultString("").equals(""));//true
		System.out.println(org.apache.commons.lang3.StringUtils.defaultString(" ").equals(""));//false
		System.out.println(org.apache.commons.lang3.StringUtils.defaultString(null,"").equals(""));//ture

	}
	
	
	public void defaultIfBlank(){
		
		String defaultValue = null;
		String defaultspace = "";
		String defaultspace2 = " ";
		String defaultspace3 = "value";
		
		System.out.println(org.apache.commons.lang3.StringUtils.defaultIfBlank(defaultValue,defaultspace3));
		System.out.println(org.apache.commons.lang3.StringUtils.defaultIfBlank(defaultspace,defaultspace3));
		System.out.println(org.apache.commons.lang3.StringUtils.defaultIfBlank(defaultspace2,defaultspace3));
	}
	
	public void defaultIfEmpty(){
		
		String defaultValue = null;
		String defaultspace = "";
		String defaultspace2 = " ";
		String defaultspace3 = "value";
		
		System.out.println(org.apache.commons.lang3.StringUtils
				.defaultIfEmpty(defaultValue,defaultspace3));
		System.out.println(org.apache.commons.lang3.StringUtils
					.defaultIfEmpty(defaultspace,defaultspace3));
		System.out.println(org.apache.commons.lang3.StringUtils
						.defaultIfEmpty(defaultspace2,defaultspace3));//return " " not value
	}
	 //反转
	public void reverse() {

		String defaultValue = null;
		String defaultspace = "";
		String defaultspace2 = " ";
		String defaultspace3 = "valueabc";
		String defaultspace4 = " valueabc ";
		String defaultspace5 = " va lue abc";

		System.out.println(org.apache.commons.lang3.StringUtils
				.reverse(defaultValue));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverse(defaultspace));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverse(defaultspace2));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverse(defaultspace3));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverse(defaultspace4));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverse(defaultspace5));

		
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverseDelimited(defaultValue, 'a'));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverseDelimited(defaultspace, 'a'));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverseDelimited(defaultspace2, 'a'));
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverseDelimited(defaultspace3, 'a'));//bcalueav
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverseDelimited(defaultspace4, 'a'));//bc aluea v
		System.out.println(org.apache.commons.lang3.StringUtils
				.reverseDelimited(defaultspace5, 'a')); //bca lue a v

	}
	
	
	public void abbreviate(){ //unknow function
		
		String strAbb = " abc ";
		System.out.println(org.apache.commons.lang3.StringUtils.abbreviate(strAbb, 4));
	}
	
	public void difference(){
		
		String diffStr = "abc";
		String diffStr2 = " adc ";
		String diffStr3 = "abde";
		System.out.println(org.apache.commons.lang3. // adc 
				StringUtils.difference(diffStr, diffStr2));
		System.out.println(org.apache.commons.lang3.//de
				StringUtils.difference(diffStr, diffStr3));
		
		System.out.println(org.apache.commons.lang3. //0
				StringUtils.indexOfDifference(diffStr, diffStr2));
		System.out.println(org.apache.commons.lang3.//2
				StringUtils.indexOfDifference(diffStr, diffStr3));
	}
	
	public void indexOfDifference(){
		
		String strArray[] ={"abc","aed","abc","ac"};
		
		System.out.println(org.apache.commons.lang3. //1
				StringUtils.indexOfDifference(strArray));
		
	}
	
	public void startsWith(){
		
		String startStr = "abc";
		
		System.out.println(org.apache.commons.lang3. //1
				StringUtils.startsWith(startStr,"ab"));
		
		String startStrs[] =  {"ab","a"};
		System.out.println(org.apache.commons.lang3. //1
				StringUtils.startsWithAny(startStr,startStrs));
		
		
		String startStrg = "acd";
		System.out.println(org.apache.commons.lang3. //1
				StringUtils.startsWithAny(startStrg,startStrs));
	}
	//unknow function
	public void normalizeSpace(){
		
		String strSpace  = " ab bc ";
		System.out.println(org.apache.commons.lang3. //1
				StringUtils.normalizeSpace(strSpace));
	}
	

	
	
	
	public static void main(String[] args) {

		StringUtilsUsage stringUtilsUsage = new StringUtilsUsage();
		//stringUtilsUsage.normalizeSpace();
		//stringUtilsUsage.startsWith();
		//stringUtilsUsage.indexOfDifference();
		stringUtilsUsage.difference();
		//stringUtilsUsage.abbreviate();
		//stringUtilsUsage.reverse();
		//stringUtilsUsage.defaultIfEmpty();
		//stringUtilsUsage.defaultIfBlank();
		//stringUtilsUsage.defaultString();
		//stringUtilsUsage.isAllUpperCase();
		//stringUtilsUsage.isAllLowerCase();
		//stringUtilsUsage.isWhitespace();
		//stringUtilsUsage.isNumeric();
		//stringUtilsUsage.isAlpha();
		//stringUtilsUsage.countMatches();
		//stringUtilsUsage.swapCase();
		//stringUtilsUsage.capitalize();
		//stringUtilsUsage.lowerCase();
		//stringUtilsUsage.upperCase();
		//stringUtilsUsage.center();
		//stringUtilsUsage.leftPad();
		//stringUtilsUsage.rightPad();
		//stringUtilsUsage.padding();
		//stringUtilsUsage.repeat();
		//stringUtilsUsage.overlay();
		//stringUtilsUsage.replace();
		//stringUtilsUsage.remove();
		//stringUtilsUsage.deleteWhitespace();
		//stringUtilsUsage.join();
		//stringUtilsUsage.splitPreserveAllTokens();
		//stringUtilsUsage.split();
		//stringUtilsUsage.substring();
		//stringUtilsUsage.lastIndexOfAny();
		//stringUtilsUsage.containsNone();
		//stringUtilsUsage.containsOnly();
		//stringUtilsUsage.indexOfAnyBut();
		//stringUtilsUsage.indexOfAnyBut();
		//stringUtilsUsage.containsAny();
		//stringUtilsUsage.indexOfAny();
		//stringUtilsUsage.contains();
		//stringUtilsUsage.containsWhitespace();
		//stringUtilsUsage.indexOfIgnoreCase();
		//stringUtilsUsage.lastIndexOf();
		//stringUtilsUsage.ordinalIndexOf();
		//stringUtilsUsage.indexOf();
		//stringUtilsUsage.utilsEqualsIgnoreCase();
		//stringUtilsUsage.utilsEquals();
		//stringUtilsUsage.stripAll();
		//stringUtilsUsage.stripEnd();
		//stringUtilsUsage.stripStart();
		//stringUtilsUsage.stripToEmpty();
		//stringUtilsUsage.stripToNull();
		//stringUtilsUsage.strip();
		//stringUtilsUsage.trimToEmpty();
		//stringUtilsUsage.trimToNull();
		//stringUtilsUsage.trim();
		//stringUtilsUsage.isBlank();	
		//stringUtilsUsage.isEmpty();	
	}

}
