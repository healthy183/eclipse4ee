package com.kang.main.controller;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.kang.main.service.IdwrMainService;

@RemoteProxy(name="dwrMainController")
public class DwrMainController {

	@Autowired
	@Qualifier("dwrMainServiceImpl")
	private IdwrMainService dwrMainServiceImpl;
	
	
	@RemoteMethod
	public String lgn(String usrNameVal,String usrPwdVal){
		
		return dwrMainServiceImpl.lgn(usrNameVal,usrPwdVal);
	}
	
	
}
