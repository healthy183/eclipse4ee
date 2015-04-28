package com.javaSE.thread;

public class Interrupt {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new InterruptThread());
		
		thread.start();
		
		thread.interrupt();//robid to  choke thread like  wait() join() sleep() 

		System.out.println(thread.isInterrupted());//thread is not choking?
		
		System.out.println(thread.interrupted());
		
	}
}

class InterruptThread  implements Runnable{

	@Override
	public void run() {
		
		System.out.println("runing!");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("test interrupt!");
	}
	
	
}



