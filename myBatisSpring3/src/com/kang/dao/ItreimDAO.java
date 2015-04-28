package com.kang.dao;

import com.kang.model.TReim;

public interface ItreimDAO {

	public TReim findById(int rmid);
	
	public TReim findByIdWithLeftJoin(int rmid);
	
	public TReim selectTreimForOne(int rmid);
	
	public void addTReim(TReim treim);
	
	public TReim findWithOneToMany(int rmid);

}



