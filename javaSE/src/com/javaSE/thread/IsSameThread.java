package com.javaSE.thread;

public class IsSameThread {
		
	public static void main(String[] args) {
		
		
		
		TestThread testThread  = new TestThread();
		
		Thread thread =  new Thread(testThread);
		
		thread.start();
		
		long threadId = thread.getId();
		
		long currentId = Thread.currentThread().getId();
		
		System.out.println(threadId == currentId);//false
		
		thread.run();
		
		long newthreadId = thread.getId();
		
		System.out.println(threadId == newthreadId);
		
		
	}
	
	
	

}

class TestThread implements Runnable{

	@Override
	public void run() {
		System.out.println("thread!");
	}
	
	
}

