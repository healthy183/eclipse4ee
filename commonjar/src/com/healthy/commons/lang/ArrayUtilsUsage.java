package com.healthy.commons.lang;

import org.apache.commons.lang3.ArrayUtils;



public class ArrayUtilsUsage {

	private int[] intArray1 = { 2, 4, 8, 16 };
	private int[] intArray11 = { 2, 4, 8 };
	private int[] intArray12 = { 2, 4, 2,3,5 };
	private int[][] intArray2 = { { 1, 2 }, { 2, 4 }, { 3, 8 }, { 4, 16 } };
	
	private char[] charArray = {'a','b','c'};
	
	private  Object[][] notAMap = { 
            { "A", new Double(100) },
            { "B", new Double(80) }, 
            { "C", new Double(60) },
            { "D", new Double(40) }, 
            { "E", new Double(20) } 
    };
	
	private Character[] characterArray = {'a','b','c','d'};
	
	
	public void arrayToString(){
		
		System.out.println(ArrayUtils.toString(intArray1));
		
		//double dimensional array
		 System.out.println(ArrayUtils.toString(intArray2));
		
		 System.out.println(ArrayUtils.toString(notAMap));
	}
	
	public void arrayHashCode(){
		
		System.out.println(ArrayUtils.hashCode(intArray1));
		System.out.println(ArrayUtils.hashCode(intArray2));
		
		int[] intArray1 = { 2, 4, 8, 16 };
	    int[] intArray11 = { 2, 4, 8,16 };
		
		System.out.println(intArray1 == intArray11);//why the same hashcode return false?
		System.out.println(intArray1.equals(intArray2));
		
	}
	
	public void isEquals(){
		
		int[] intArray1 = { 2, 4, 8, 16 };
	    int[] intArray11 = { 2, 4, 8, 16 };
		
		System.out.println(ArrayUtils.isEquals(intArray1,intArray11));
	}

	public void toMap(){
	
		System.out.println(ArrayUtils.toMap(notAMap));
		
		Object[] obj = { 2, 4, 8, 16 }; //java.lang.IllegalArgumentException:
		System.out.println(ArrayUtils.toMap(obj));
		
		//java.lang.IllegalArgumentException:
		Object[] obj2 = {  new Double(100), new Double(80) };
		System.out.println(ArrayUtils.toMap(obj2));
	}
	
	public void arrayClone(){
		
		int[] cloneIntArray  = ArrayUtils.clone(intArray1);
		System.out.println(ArrayUtils.toString(cloneIntArray));
	}
	
	public void subarray(){
		
		int[] intArray1 = { 2, 4, 8, 16 };
		int[] intArray = ArrayUtils.subarray(intArray1,0,2);
		System.out.println(ArrayUtils.toString(intArray));
	}
	
	public void isSameLength(){
		System.out.println(ArrayUtils.isSameLength(intArray1, intArray11));
		System.out.println(ArrayUtils.isSameLength(intArray1, intArray1));
	}
	
	public void getLength(){
		
		System.out.println(ArrayUtils.getLength(intArray1));
		System.out.println(ArrayUtils.getLength(null));
	}
	
	public void isSameType(){
		
		System.out.println(ArrayUtils.isSameType(intArray1, intArray1));
		System.out.println(ArrayUtils.isSameType(intArray1, intArray11));
		System.out.println(ArrayUtils.isSameType(intArray1, intArray2));
		System.out.println(ArrayUtils.isSameType(intArray1, notAMap));
	}
	
	public void reverse(){
		
		ArrayUtils.reverse(intArray1);
		System.out.println(ArrayUtils.toString(intArray1));
	}
	
	public void indexOf(){
		
		int index = ArrayUtils.indexOf(intArray1, 4);
		System.out.println(index);
	   /** arg0:array
		 * arg1:objectToFind
		 * arg2:startIndex
		 * actually,indexOf(arg0,arg1,arg2) only get the first index,
		 * if need the last,pls search through lastIndexOf(arg0,arg1,arg2);
 		 **/
 		int index2 = ArrayUtils.indexOf(intArray1,2,3);
		System.out.println(index2);
		
		int index3 = ArrayUtils.indexOf(intArray1,8,0);
		System.out.println(index3);
		
	}
	
	public void lastIndexOf(){
		
		int index = ArrayUtils.lastIndexOf(intArray12, 4);
		System.out.println(index);
		
		int index2 = ArrayUtils.lastIndexOf(intArray12, 2,4);
		System.out.println(index2);
		
		int index3= ArrayUtils.indexOf(intArray12, 2,0);
		System.out.println(index3);
	}
	
	public void contains(){
		
		System.out.println(ArrayUtils.contains(intArray12, 1));
		System.out.println(ArrayUtils.contains(intArray12, 2));
		
	}
	
	public void toPrimitive(){
		
		char[] charAarry = ArrayUtils.toPrimitive(characterArray);
		System.out.println(ArrayUtils.toString(charAarry));
		System.out.println(ArrayUtils.toString(ArrayUtils.toObject(charAarry)));
		
		}
	
	public void isMethod(){
		System.out.println(ArrayUtils.isEmpty(characterArray));
		Long[] nullLongArray = null;
		System.out.println(ArrayUtils.isEmpty(nullLongArray));
	}
	
	public void addOne(){
		System.out.println(  
			ArrayUtils.toString(ArrayUtils.add(intArray1, 3)));
							 //add with index 
		System.out.println(  //arg0:array arg1:index arg2:addObject
				ArrayUtils.toString(ArrayUtils.add(charArray, 2,'d')));
	}
	
	public void addAll(){
		int[] allArray = ArrayUtils.addAll(intArray1, intArray11);
		System.out.println(ArrayUtils.toString(allArray));
	}
	
	public void removeWithIndex(){
		
		System.out.println( //{2,8,16}
			ArrayUtils.toString(ArrayUtils.remove(intArray1, 1)));
		
		System.out.println(//{4,8,16}
				ArrayUtils.toString(ArrayUtils.removeElement(intArray1, 2)));
		
		System.out.println(//{2,4,8,16}
				ArrayUtils.toString(ArrayUtils.removeElement(intArray1, 3)));
	}
	
	
	public static void main(String[] args) {
		
		ArrayUtilsUsage arrayUtilsUsage = new ArrayUtilsUsage();
		//arrayUtilsUsage.arrayToString();
		//arrayUtilsUsage.arrayHashCode();
		//arrayUtilsUsage.isEquals();
		//arrayUtilsUsage.toMap();
		//arrayUtilsUsage.arrayClone();
		//arrayUtilsUsage.subarray();
		//arrayUtilsUsage.isSameLength();
		//arrayUtilsUsage.getLength();
		//arrayUtilsUsage.isSameType();
		//arrayUtilsUsage.reverse();
		//arrayUtilsUsage.indexOf();
		//arrayUtilsUsage.lastIndexOf();
		//arrayUtilsUsage.contains();
		//arrayUtilsUsage.toPrimitive();
		//arrayUtilsUsage.isMethod();
		//arrayUtilsUsage.addAll();
		//arrayUtilsUsage.addOne();
		arrayUtilsUsage.removeWithIndex();
	}

}
