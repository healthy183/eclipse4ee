package com.kang.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kang.bestPay.util.SysUserRequest;
import com.kang.bestPay.util.TPageParameter;
import com.kang.model.SysUsers;
import com.kang.service.IuserService;
import com.kang.util.Page;

public class TestBestPayPlugins {
	
	
	
	/*bestpay版本*/
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IuserService  iuserService = (IuserService)applicationContext.getBean("userServiceImpl");
		
	
		SysUserRequest request = new SysUserRequest();
		request.setUsrname("s");
		
		TPageParameter  page = new TPageParameter();
		request.settPageParameter(page);
		
		
		List<SysUsers>  users = iuserService.findByBestPayPage(request);


		
		System.out.println();
		
		
		
	}
	

}
