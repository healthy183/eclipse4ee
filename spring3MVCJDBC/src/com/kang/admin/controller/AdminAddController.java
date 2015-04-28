package com.kang.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kang.admin.service.IadminAddService;
import com.kang.model.SysRoles;
import com.kang.model.SysUsers;

@Scope("prototype")
@Controller
@RequestMapping("/adminAdd")
public class AdminAddController {

	@Autowired
	@Qualifier("adminAddServiceImpl")
	private IadminAddService adminAddServiceImpl;
	
	
	//新增用户同时新增角色(测试两个一对多,即多对多)
	@RequestMapping("/addUserAndRole")
	public String addUserAndRole(HttpServletRequest request){
			//查询所有员工类型为0的员工即领导
			List<SysUsers> leadList = adminAddServiceImpl.findAllLead();
			request.setAttribute("leadList",leadList);
			
			//查询所有角色
			List<SysRoles> rolesList = adminAddServiceImpl.findAllRoles();
			request.setAttribute("rolesList",rolesList);
			return "adminAdd/addUserAndRole";
		}
	
	@RequestMapping(value="/addUserAndRoleSuccess",method=RequestMethod.POST)
	public String addUserAndRoleSuccess(SysUsers newUser,SysRoles newRole,HttpServletRequest request){
		String leadId =	request.getParameter("leadId");
		String[] roleIdCheck = request.getParameterValues("roleIdCheck");
		adminAddServiceImpl.saveUserAndRole(newUser,newRole,roleIdCheck,leadId);
		return "adminAdd/addUserAndRoleSuccess";
	}
	
	@RequestMapping("/addUsr")
	public String addUsr(HttpServletRequest request) {

		//查询所有员工类型为0的员工即领导
		List<SysUsers> leadList = adminAddServiceImpl.findAllLead();
		request.setAttribute("leadList",leadList);
		
		//查询所有角色
		List<SysRoles> rolesList = adminAddServiceImpl.findAllRoles();
		request.setAttribute("rolesList",rolesList);
		
		return "adminAdd/addUsr";
	}
	
	@RequestMapping("/addMyUsr")
	public String addMyUsr(HttpServletRequest request){
		//查询所有角色
		List<SysRoles> rolesList = adminAddServiceImpl.findAllRoles();
		request.setAttribute("rolesList",rolesList);
		
		return "adminAdd/addMyUsr";
	}
	
	
}
