package com.javaSE.thread;


public class BillPlay {

	public static void main(String[] args) {

		//TestDefaultClass test = new TestDefaultClass();
		IsRoseClass	rose = new IsRoseClass();
		
		new Thread(new PayThread("tom",rose)).start();
		
		new Thread(new PayThread("Jim",rose)).start();
		
	}
	
	private static class PayThread implements Runnable{

		int count = 0;
		String name = null;
		IsRoseClass roseClass = null;
		
		public PayThread(String name, IsRoseClass roseClass) {
			super();
			this.name = name;
			this.roseClass = roseClass;
		}

		@Override
		public void run() { 

			while(!Thread.interrupted()) {
				
				synchronized(roseClass){
					
					if(roseClass.isRose){
						
						System.out.println(name+" rose!");
						break;
						
					}else if(++count == 5){
						
						roseClass.isRose = Boolean.TRUE;
						
						System.out.println(name+" my count is "+ count);
						
						System.out.println(name+" win!");
						break;
						
					}
					
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(name+" my count is "+ count);
				
			}
			
			
			
		}
	}
	
	private static class IsRoseClass{
		boolean isRose = Boolean.FALSE;
	}

}



