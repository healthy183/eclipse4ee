package com.aop.annoation.simpleDeclareParents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

	@DeclareParents
		(value="com.aop.annoation.simpleBeforeAdvice.NativeWaiter",
			defaultImpl=SmartSeller.class)
	public Seller seller;
	
}
