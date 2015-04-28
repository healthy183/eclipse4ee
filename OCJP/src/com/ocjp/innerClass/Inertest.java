package com.ocjp.innerClass;

import com.ocjp.innerClass.enclosingone.Insideone;

class Outer{
	 static class Inner{}
}

class enclosingone {
	public class Insideone{} 
}

 public class Inertest {

	 	public static void main(String[] args) {
		
	 		Outer.Inner inner = new Outer.Inner();
	 		
	 		enclosingone eo = new enclosingone();
	 		
	 		Insideone insideone = eo.new Insideone();
		
	 	   //Insideone insideone2 = new Insideone();
	 		
	 		//Insideone insideone2 = new enclosingone.Insideone();
	 	}

}
