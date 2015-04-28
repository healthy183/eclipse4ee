package com.kang.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kang.admin.service.IadminDelService;
import com.kang.model.SysUsers;

@Scope("prototype")
@Controller
@RequestMapping("/adminDel")
public class AdminDelController {

	@Autowired
	@Qualifier("adminDelServiceImpl")
	private IadminDelService adminDelServiceImpl;
	
	
	@RequestMapping("/delUsr")
	public String delUsr(HttpServletRequest request){
		
		SysUsers vo = (SysUsers)request.getSession().getAttribute("lgnUser");
		//查询所有用户除了自己 
		List<SysUsers> usrVoList = adminDelServiceImpl.findAllButMe(vo.getUsrid());
		
		request.setAttribute("usrVoList",usrVoList);
		return "adminDel/delUsr";
	}
	
	@RequestMapping(value="/delUsrSuccess")//,method=RequestMethod.POST
	public String delUsrSuccess(HttpServletRequest request,String usrid){
		
		adminDelServiceImpl.delUsr(usrid);
		
		SysUsers vo = (SysUsers)request.getSession().getAttribute("lgnUser");
		//查询所有用户除了自己 
		List<SysUsers> usrVoList = adminDelServiceImpl.findAllButMe(vo.getUsrid());
		
		request.setAttribute("usrVoList",usrVoList);
		return "adminDel/delUsr";
	}
	
}
