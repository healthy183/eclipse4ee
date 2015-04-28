package com.ocjp.thread;

public class TestNew implements  Runnable {

	@Override
	public void run() {
		System.out.println("thread is running!");
	}
	
	public static void main(String[] args) {
 //
		//new Thread(new TestNew()).start(); ;
		double a =  5890.5;
		double var =  a*3;
		System.out.println(var);//17671.5
		
		int roda = 505+538;
		System.out.println(roda);//1043
		
		System.out.println(var + roda); //18714.5
		
		System.out.println(18714.5 +264); //18978.5
		
		//我欠Alen 100RMB
		//我欠rogda 1043HK$
		//我欠cason 3000HK$ +房费 5890.5HK$+264HK$
		//Alen欠我100HK$
		//
		System.out.println(3000+5890.5+264);
		//我欠cason 3000HK$ +房费 5890.5HK$+264HK$
		
		//cason:9154.5 - 8155 =1000-500= 500(港币)
		//mark:9264 - 7000 = 2264(1800RMB)
		
		double sean = 163.6;
		double ba = 191.1;
		double my = 411.8;
		double chuang = 139;
		double welcome  = 330;
		double fan = 120*5+50;
		double che  = 100;
		double dache = 150;
		double  shu = 192;
		double wan = 50;
		
		double all =  sean + ba+ my+chuang+welcome+fan+che+dache+shu+wan;
		System.out.println(all);
		
		
	}
 

}
