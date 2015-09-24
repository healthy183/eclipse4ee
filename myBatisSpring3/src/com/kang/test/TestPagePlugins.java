package com.kang.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kang.model.SysUsers;
import com.kang.service.IuserService;
import com.kang.util.Page;

public class TestPagePlugins {

	
	/*网页版本*/
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IuserService  iuserService = (IuserService)applicationContext.getBean("userServiceImpl");
		
		Page page = new Page();
		
		
		   
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usrname", "s");  
		
		page.setParams(params);
		
		List<SysUsers>  users = iuserService.findByPage(page);


		
		System.out.println();
		
		
		
	}
	
	
}
