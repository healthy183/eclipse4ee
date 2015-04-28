package com.aop.annoation.proceedingArgs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.interfaces.Iwaiter;

public class TestArgs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("com/aop/annoation/proceedingArgs/args.xml");
		NaughtWaiter w = (NaughtWaiter)app.getBean("naughtWaiter");
		//w.smileTo( 5,"梁健康");
		w.smileTo("梁健康",5);
	}

}
