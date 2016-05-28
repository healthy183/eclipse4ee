package com.javaSE.visit;

public class FinalClass {

	private final int i = 0;
	
	public void test(){
		//i  = 1;i身为final全局变量无法修改
		 final Integer j ;//j无初始化,则可以赋值一次;
		 j = 1;
		 //j = 2;//无法再次赋值
	}
	
	public  void beforecompile(){
		String a = "hello2";
		final String b = "hello";//定义基本类型和String为final,则编译器会把b当做编译期常量使用，在编译前就分配栈内存,所以a == c true
		String d = "hello";
		
		String c = b + 2;
		String e = d + 2;

		System.out.println(a == c);
		System.out.println(a == e);
	}

	public  String  getHello(){
		return "hello";
	}
	
	public  void afterCompile(){
		String  a = "hello2";
		final String b   = getHello();//需要调用方法才能确定值,故编译器不当其为编译期常量
		String c = b + 2;
		System.out.println(a == c);
	}
	
	
	public  void finalClass(final RunClass runClass){
		runClass.setRunVal(runClass.getRunVal()+2);
	}
	
	public void chanageClass(){
		final RunClass runClass = new RunClass(2);
		finalClass(runClass);
		System.out.println(runClass.getRunVal());
	}
	
	public static void main(String[] args) {
		FinalClass finalClass = new FinalClass();
		//finalClass.beforecompile();
		//finalClass.afterCompile();
		finalClass.chanageClass();
	}
	
}

class RunClass {

	private  Integer runVal;
	
	RunClass(Integer runVal){
		this.runVal = runVal;
	}

	public Integer getRunVal() {
		return runVal;
	}

	public void setRunVal(Integer runVal) {
		this.runVal = runVal;
	}
}



