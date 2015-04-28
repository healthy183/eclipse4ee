package com.kang.admin.service;

import java.util.List;

import com.kang.model.SysRoles;
import com.kang.model.SysUsers;

public interface IadminAddService {

	List<SysUsers> findAllLead();

	List<SysRoles> findAllRoles();

	void saveUserAndRole(SysUsers newUser, SysRoles newRole,
			String[] roleIdCheck, String leadId);

}
