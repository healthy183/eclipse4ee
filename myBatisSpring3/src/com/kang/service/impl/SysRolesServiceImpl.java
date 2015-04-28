package com.kang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kang.dao.SysRolesDAO;
import com.kang.model.SysRoles;
import com.kang.model.UsrRoleLink;
import com.kang.service.IsysRolesService;

@Scope("prototype")
@Service("sysRolesServiceImpl")
@Transactional
public class SysRolesServiceImpl implements IsysRolesService {

	@Autowired
	private	SysRolesDAO sysRolesDAO;

	@Override
	public void findwithOneToMany() {
		SysRoles role = sysRolesDAO.findwithOneToMany(16);
		System.out.println(role.getRoleId());
		for(UsrRoleLink usrRoleLink : role.getLinkList()){
			System.out.println(usrRoleLink.getLinkId());
		}
	}
	
	@Override
	public void findByProperty() {
		//SysRoles role = sysRolesDAO.findByProperty(16, "修改员工信息");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleId",16);
		map.put("roleName","修改员工信息");
		SysRoles role = sysRolesDAO.findByProperty(map);
		System.out.println(role.getRoleUrl());
		//SysRoles role = sysRolesDAO.findByPropertySecond(16, "修改员工信息");//为什么不行?
		//System.out.println( role  == null);
	}
	
	public void selectIf(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleId",16);
		map.put("roleName","修改员工信息");
		SysRoles role = sysRolesDAO.selectIf(map);
		System.out.println(role.getRoleUrl());
	}
	
	@Override
	public void selectChoose() {
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("roleId",16);
		map.put("roleName","修改员工信息");
		SysRoles role = sysRolesDAO.selectChoose(map);
		System.out.println(role.getRoleUrl());
	}
	
	@Override
	public void selectForeach() {
		List<Integer> intList  = new ArrayList<Integer>();
		intList.add(16);
		intList.add(17);
		intList.add(18);
		List<SysRoles> roleList = sysRolesDAO.selectForeach(intList);
		for(SysRoles role : roleList){
			System.out.println(role.getRoleName());
		}
	}
	
	@Override
	public void selectin() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleIdList", "(16,17,18)");
		List<SysRoles> roleList =  sysRolesDAO.selectin(map);
		for(SysRoles role : roleList){
			System.out.println(role.getRoleName());
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IsysRolesService isysRolesService =  (IsysRolesService) applicationContext.getBean("sysRolesServiceImpl");
		//isysRolesService.findwithOneToMany();
		//isysRolesService.findByProperty();
		//isysRolesService.selectIf();
		//isysRolesService.selectChoose();
		//isysRolesService.selectForeach();
		isysRolesService.selectin();
	}

	

	

	

	

}
