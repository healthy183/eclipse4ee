package com.kang.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kang.main.service.ImainService;
import com.kang.model.SysUsers;


@Scope("prototype")
@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private ImainService mainServiceImpl;
	
	@RequestMapping(value="/lgn",method=RequestMethod.POST)
	public String lgn(SysUsers user,HttpServletRequest request){
		
		//System.out.println("a");
		SysUsers lgnUser = mainServiceImpl.lgn(user);
		if(lgnUser != null){
			
			HttpSession session = request.getSession();
			session.setAttribute("lgnUser",lgnUser);
			
			//System.out.println("b");
			return "forward:/welcome/welcome.jsp";
		}
		System.out.println("c");
		return "forward:/index.jsp";
	}
	
	@RequestMapping(value="/lgnOut")
	public String lgnOut(HttpServletRequest request){
		request.getSession().invalidate();
		return "forward:/index.jsp";
	}
	
	
}
