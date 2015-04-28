package com.kang.service;

import com.kang.model.TReim;

public interface ItreimService {
	
	public void findById();
	
	public void findByIdWithLeftJoin();
	
	public TReim selectTreimForOne();

	public void addTReim();
	
	public void findWithOneToMany();
}
