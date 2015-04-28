package com.aop.staticProxy;


public class TestStaticProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ForumServiceImpl f = new ForumServiceImpl();
		f.removeTop(11);
		f.removeForum(22);
	}

}
