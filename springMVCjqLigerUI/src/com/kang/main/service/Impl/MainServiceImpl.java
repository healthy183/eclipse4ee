package com.kang.main.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kang.dao.IbaseDAO;
import com.kang.dao.ext.ImyUsrDAO;
import com.kang.main.service.ImainService;
import com.kang.model.MyUsr;
import com.kang.service.BaseHibernateService;
import com.kang.service.IbaseService;

@Scope("prototype")
@Service("mainServiceImpl")
public class MainServiceImpl 
		extends BaseHibernateService<MyUsr, Integer>
				implements ImainService {
	
	private ImyUsrDAO myUsrDaoImpl;
	@Override
	@Autowired
	@Qualifier("myUsrDaoImpl")
	public void setBaseDAO(IbaseDAO<MyUsr, Integer> baseDAO) {
		this.baseDAO = baseDAO;
		this.myUsrDaoImpl =  (ImyUsrDAO) baseDAO;
	}

	@Override
	public MyUsr lgn(MyUsr webUsr) {
		
		List<MyUsr> usrList = myUsrDaoImpl.findByProperty("usrName",webUsr.getUsrName());
		
		if(!usrList.isEmpty()){
			MyUsr usr = usrList.get(0);
				if(usr.getUsrPwd().equals(webUsr.getUsrPwd())){
					return usr;
				}else{
					return null;
				}
		}
		return null;
	}

}
