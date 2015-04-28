package com.ocjp.memory;

class Vo{
	
	private  int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

public class VoMemory {

	

	public void testVo(Vo vo){
	
		vo.setI(2);
	}

	public static void main(String[] args) {

		
		VoMemory test = new VoMemory();
		
		Vo vo =new Vo();
		vo.setI(1);
		
		test.testVo(vo);
		
		System.out.println(vo.getI());
		
	}

}
