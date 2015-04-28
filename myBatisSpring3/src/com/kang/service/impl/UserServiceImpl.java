package com.kang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kang.dao.IsysUsersDAO;
import com.kang.model.SysUsers;
import com.kang.service.IuserService;

@Scope("prototype")
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements IuserService {

	@Autowired 
	private	IsysUsersDAO sysUsersDAO;
	
	@Override
	public SysUsers findById(int usrid){
		return sysUsersDAO.findById(usrid);
	} 
	
	@Override
	public SysUsers getById(int usrid){
		return sysUsersDAO.getById(usrid);
	} 
	
	@Override
	public List<SysUsers> findAll(){
		return sysUsersDAO.findAll();
	};
	
	@Override
	public void insertUsr() {
		SysUsers user = new SysUsers();
		user.setUsrname("myBatisUser");
		user.setUsrpwd("123");
		user.setUsrtype(1);
		sysUsersDAO.insertUsr(user);
		System.out.println(user.getUsrid());
	}	
	
	@Override
	public void updtUsr() {
		SysUsers user = new SysUsers();
		user.setUsrname("myBatisUser");
		user.setUsrpwd("abc");
		sysUsersDAO.updtUsr(user);
		System.out.println(user.getUsrpwd());
	}
	
	@Override
	public void deleteUsr() {
		sysUsersDAO.deleteUsr(114);
	}
	 
	@Override  //为什么不行?
	public void findWithOneToMany() {
		SysUsers usr = sysUsersDAO.findWithOneToMany(94);
		System.out.println(usr == null);
		//System.out.println(usr.getUsrname());
	}
	
		public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IuserService  iuserService = (IuserService)applicationContext.getBean("userServiceImpl");
		//SysUsers user = iuserService.findById(100);
		//SysUsers user = iuserService.getById(100);
		//System.out.println(user.getUsrname());
		
		/*for(SysUsers usr : iuserService.findAll()){
				System.out.println(usr.getUsrname());
		}*/
		//iuserService.insertUsr();
		//iuserService.updtUsr();
		//iuserService.deleteUsr();
		iuserService.findWithOneToMany();
	}

		

		

		

		
	
}
