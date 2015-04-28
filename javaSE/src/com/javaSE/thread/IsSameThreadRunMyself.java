package com.javaSE.thread;

public class IsSameThreadRunMyself implements Runnable {
	
	public void run() {
			System.out.println("run!");
	}

	
	
	
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new IsSameThreadRunMyself());
		
		thread.start();
		
		long thisId = thread.getId();
		
		long currentId = thread.currentThread().getId();
		
		System.out.println(thisId == currentId);
		
	}
	
	
	
}
