package com.kang.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kang.bestPay.util.SysUserRequest;
import com.kang.model.SysUsers;
import com.kang.util.Page;

/*@Scope("prototype")
@Repository("")*/
public interface IsysUsersDAO {
	
	public SysUsers findById(int usrid);

	public SysUsers getById(int usrid);
	
	public List<SysUsers> findAll();
	
	public void insertUsr(SysUsers user);
	
	public void updtUsr(SysUsers user);
	
	public void deleteUsr(int usrId);
	
	public SysUsers findWithOneToMany(int usrid);

	public List<SysUsers>  findByPageObj(Page page);

	public List<SysUsers> findByBestPayPage(SysUserRequest request);
	
}
