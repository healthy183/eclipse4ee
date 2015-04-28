package com.kang.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gialen.kang.tool.Page;
import com.kang.dao.BaseHibernateDAO;
import com.kang.dao.ext.ImyUsrDAO;
import com.kang.model.MyUsr;

@Scope("prototype")
@Repository("myUsrDaoImpl")
public class MyUsrDaoImpl extends BaseHibernateDAO<MyUsr,Integer> 
			implements ImyUsrDAO {
	
	
	
}
