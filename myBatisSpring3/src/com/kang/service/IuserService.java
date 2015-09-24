package com.kang.service;

import java.util.List;

import com.kang.bestPay.util.SysUserRequest;
import com.kang.model.SysUsers;
import com.kang.util.Page;

public interface IuserService {

	SysUsers findById(int usrid);

	SysUsers getById(int usrid);

	List<SysUsers> findAll();
	
	public void insertUsr();

	public void updtUsr();
	
	public void deleteUsr();
	
	public void findWithOneToMany();
	
	List<SysUsers>  findByPage(Page page);

	List<SysUsers> findByBestPayPage(SysUserRequest request);

}
