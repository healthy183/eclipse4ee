package com.aop.annoation.simpleAfterReturning.thisMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.annoation.simpleDeclareParents.Seller;
import com.aop.interfaces.Iwaiter;

public class TestThis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/simpleAfterReturning/thisMethod/testThis.xml");
		Iwaiter w =(Iwaiter)app.getBean("thisNaughtWaiter");
		w.greetTo("梁健康");
		w.serveTo("梁健康abc");
		//Seller seller = (Seller)w;
		((Seller)w).sell("A","梁健康");//????
	}

}
