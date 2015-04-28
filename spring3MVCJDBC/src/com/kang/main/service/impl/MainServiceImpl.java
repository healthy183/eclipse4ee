package com.kang.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kang.dao.UserDao;
import com.kang.main.service.ImainService;
import com.kang.model.SysUsers;

@Scope("prototype")
@Service("mainServiceImpl")
public class MainServiceImpl implements ImainService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
		
	@Override 
 	public SysUsers lgn(SysUsers user) {
		return userDao.lgn(user.getUsrname(), user.getUsrpwd());
	}

}
