package com.aop.dynamicProxy;

import com.aop.interfaces.IforumService;

public class ForumServiceImpl implements IforumService {

	@Override
	public void removeTop(int topicId) {
		
		System.out.println("removeTop "+ topicId);
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeForum(int formumId) {
		
		System.out.println("removeForum "+  formumId);
		
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
