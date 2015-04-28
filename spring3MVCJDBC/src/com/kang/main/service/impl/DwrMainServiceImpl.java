package com.kang.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kang.dao.UserDao;
import com.kang.main.service.IdwrMainService;
import com.kang.model.SysUsers;

@Scope("prototype")
@Service("dwrMainServiceImpl")
public class DwrMainServiceImpl implements IdwrMainService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	
	@Override
	public String lgn(String usrNameVal, String usrPwdVal) {
		SysUsers usr = userDao.lgn(usrNameVal,usrPwdVal);
		return usr != null?"ok":"no";
	}

}
