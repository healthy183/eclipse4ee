package com.kang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kang.dao.IsysUsersDAO;
import com.kang.dao.ItreimDAO;
import com.kang.model.SysUsers;
import com.kang.model.TReim;
import com.kang.service.ItreimService;
import com.kang.service.IuserService;

@Scope("prototype")
@Service("treimServiceImpl")
@Transactional
public class TreimServiceImpl implements ItreimService {

	@Autowired
	private ItreimDAO itreimDAO;
	@Autowired
	private IsysUsersDAO usrDAO;
	
	@Override
	public void findById() {
		TReim treim =  itreimDAO.findById(2);
		System.out.println(treim.getRmname());
		System.out.println(treim.getSysUsers().getUsrname());
	}
	
	@Override
	public void findByIdWithLeftJoin() {
		TReim treim =  itreimDAO.findByIdWithLeftJoin(2);
		System.out.println(treim.getRmname());
		System.out.println(treim.getSysUsers().getUsrname());
	}
	
	@Override
	public TReim selectTreimForOne() {
		TReim treim =  itreimDAO.selectTreimForOne(2);
		System.out.println(treim.getRmname());
		System.out.println(treim.getSysUsers().getUsrname());
		return treim;
	}
	
	@Override
	public void addTReim() {
		
		SysUsers usr = new SysUsers();
		usr.setUsrname("wfhggg");
		usrDAO.insertUsr(usr);
		
		TReim treim = new TReim();
		treim.setSysUsers(usr);
		
		treim.setRmname("wfhgggTreim");
		itreimDAO.addTReim(treim);
		
		System.out.println( usr.getUsrid());
		System.out.println(treim.getRmid());
	}
	
	@Override
	public void findWithOneToMany() {
		TReim treim =  itreimDAO.findWithOneToMany(2);
		System.out.println(treim.getRmname());
		System.out.println(treim.getSysUsers().getUsrname());
	}
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItreimService  itreimService = (ItreimService)applicationContext.getBean("treimServiceImpl");
		//itreimService.findById();
		itreimService.findByIdWithLeftJoin();
		//itreimService.selectTreimForOne();
		//itreimService.addTReim();
		//itreimService.findWithOneToMany();
	}

	
	
}
