package com.kang.main.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kang.main.service.ImainService;
import com.kang.model.MyUsr;


@Scope("prototype")
@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	@Qualifier("mainServiceImpl")
	private ImainService mainServiceImpl;

	@RequestMapping(value="/lgn",method=RequestMethod.POST)
	public String lgn(MyUsr webUsr,HttpSession session){
		
		MyUsr lgnUsr = mainServiceImpl.lgn(webUsr);
		
		if(lgnUsr != null){
			session.setAttribute("lgnUsr",lgnUsr);
			return "main/main";
		}
		return "forward:/index.jsp";
		
	}
	@RequestMapping(value="/findAllUsr")
	public String findAllUsr(HttpServletRequest request){
		
		List<MyUsr> usrList = mainServiceImpl.findAll();
		request.setAttribute("usrList",usrList);
		
		return "user/findAll";
	}
	// 
	@RequestMapping(value="/isHadName/{usrNameVar}",method=RequestMethod.POST)
	public @ResponseBody String isHadName(@PathVariable("usrNameVar") String usrNameVar){
		
		List<MyUsr> usrList = mainServiceImpl.findByProperty("usrName", usrNameVar);
		
		System.out.println(usrList);
		
		return usrList.isEmpty()?"true":"false";
	}
	
	//
	@RequestMapping(value="/saveUsr/{usrNameVar}/{usrPwdVar}",method=RequestMethod.POST)
	public  @ResponseBody Integer saveUsr(@PathVariable("usrNameVar") String usrNameVar,
				@PathVariable("usrPwdVar") String usrPwdVar){
			
		MyUsr myUsr = new MyUsr();
		myUsr.setUsrName(usrNameVar);
		myUsr.setUsrPwd(usrPwdVar);
		return	mainServiceImpl.merge(myUsr).getUsrId();
		
	}
	
	
	
}
