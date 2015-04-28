package com.aop.annoation.proceeding.returnVal;

import com.aop.annoation.simpleDeclareParents.Seller;

public class SmallerSeller implements Seller {

	@Override
	public int sell(String goods, String clientName) {
		System.out.println("arg0:"+goods+" arg1:"+clientName);
		return 199;
	}

}
