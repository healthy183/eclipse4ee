package com.ocjp.implement;

interface Imp{
	int k  = 0;
}

public class TestfootImp implements Imp {

	
	public static void main(String[] args) {

		 int i;
		 TestfootImp testfootImp = new TestfootImp();
		 i = testfootImp.k;
		 i = TestfootImp.k;
		 i = Imp.k; 
		 
	}

}
