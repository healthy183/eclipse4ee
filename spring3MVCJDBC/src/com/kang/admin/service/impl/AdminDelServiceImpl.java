package com.kang.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kang.admin.service.IadminDelService;
import com.kang.dao.UserDao;
import com.kang.model.SysUsers;

@Scope("prototype")
@Service("adminDelServiceImpl")
public class AdminDelServiceImpl implements IadminDelService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
	public List<SysUsers> findAllButMe(Integer usrid) {
		return userDao.findAllButMe(usrid);
	}

	@Override
	public void delUsr(String usrid) {
		userDao.delUsr(Integer.valueOf(usrid));
	}

}
