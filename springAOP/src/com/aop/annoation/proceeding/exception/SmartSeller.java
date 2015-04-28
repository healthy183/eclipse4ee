package com.aop.annoation.proceeding.exception;

import com.aop.annoation.simpleDeclareParents.Seller;

public class SmartSeller implements Seller {

	@Override
	public int sell(String goods, String clientName) {
		return 0;
	}

	public void checkBill(int billId){
		if(billId == 1){
			throw new IllegalArgumentException("iae exception");
		}else{
			throw new RuntimeException();
		}
	}
	
}
