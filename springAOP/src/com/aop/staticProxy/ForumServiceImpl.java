package com.aop.staticProxy;

import com.aop.interfaces.IforumService;


public class ForumServiceImpl implements IforumService {

	@Override
	public void removeTop(int topicId) {
		
		PerformanceMonitor.begin("com.aop.simple.ForumServiceImpl.removeTop");
		
		System.out.println("remove topicId is"+ topicId);
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		PerformanceMonitor.end();
		
	}

	@Override
	public void removeForum(int formumId) {
		
		PerformanceMonitor.begin("com.aop.simple.ForumServiceImpl.removeForum");
		
		System.out.println("remove topicId is"+ formumId);
		
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		PerformanceMonitor.end();
		
	}

}
