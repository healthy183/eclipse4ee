package com.kang.service;

import java.util.List;

import com.kang.model.SysUsers;

public interface IuserService {

	SysUsers findById(int usrid);

	SysUsers getById(int usrid);

	List<SysUsers> findAll();
	
	public void insertUsr();

	public void updtUsr();
	
	public void deleteUsr();
	
	public void findWithOneToMany();

}
