package com.aop.annoation.simpleAfterReturning.thisMethod;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import com.aop.annoation.simpleDeclareParents.Seller;
import com.aop.annoation.simpleDeclareParents.SmartSeller;

@Aspect
public class EnableSellerAspect {

	@DeclareParents
		(value="com.aop.annoation.simpleAfterReturning.thisMethod.NaughtWaiter",
			defaultImpl=SmartSeller.class)
	public static Seller seller;
	
}
