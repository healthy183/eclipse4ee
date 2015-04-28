package com.kang.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kang.admin.service.IadminAddService;
import com.kang.dao.RoleDao;
import com.kang.dao.UserDao;
import com.kang.dao.UsrRoleLinkDao;
import com.kang.model.SysRoles;
import com.kang.model.SysUsers;
import com.kang.model.UsrRoleLink;


@Scope("prototype")
@Service("adminAddServiceImpl")
public class AdminAddServiceImpl implements IadminAddService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Autowired
	@Qualifier("roleDao")
	private RoleDao roleDao;
	
	@Autowired
	@Qualifier("usrRoleLinkDao")
	private UsrRoleLinkDao usrRoleLinkDao;
	
	@Override //查询所有领导
	public List<SysUsers> findAllLead() {
		return userDao.findAllLead();
	}

	@Override //查询所有角色
	public List<SysRoles> findAllRoles() {
		return roleDao.findAllRoles();
	}

	@Override
	public void saveUserAndRole(SysUsers newUser, SysRoles newRole,
			String[] roleIdCheck, String leadId) {
		
		if(!leadId.equals("") && leadId != null){
			newUser.setUsrmgr(Integer.valueOf(leadId));
		}
		Integer usrId =	userDao.save(newUser);
		
		Integer roleId = null;
		
		if(newRole.getRoleName() != null && newRole.getRoleUrl() != null){
			 roleId = roleDao.save(newRole);
		}
		
		List<UsrRoleLink> linkList = new ArrayList<UsrRoleLink>();
		
		UsrRoleLink newUsrRoleLink = null;
		
		if(roleIdCheck != null &&  roleIdCheck.length>0){
			for(int i = 0;i<roleIdCheck.length;i++){
				newUsrRoleLink = new UsrRoleLink();
				newUsrRoleLink.setRoleid(Integer.valueOf(roleIdCheck[i]));
				newUsrRoleLink.setUsrid(usrId);
				linkList.add(newUsrRoleLink);
			}
			
		}
		
		
		if(roleId != null){
			newUsrRoleLink = new UsrRoleLink();
			newUsrRoleLink.setRoleid(roleId);
			newUsrRoleLink.setUsrid(usrId);
			linkList.add(newUsrRoleLink);
		}
		
		if(linkList.size()>0){
			usrRoleLinkDao.saveAll(linkList);
		}
		
		
	}

}
