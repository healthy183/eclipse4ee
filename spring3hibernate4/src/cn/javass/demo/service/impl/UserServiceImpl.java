package cn.javass.demo.service.impl;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.pagination.Page;
import cn.javass.common.pagination.PageUtil;
import cn.javass.common.service.impl.BaseService;
import cn.javass.demo.dao.UserDao;
import cn.javass.demo.model.UserModel;
import cn.javass.demo.model.UserQueryModel;
import cn.javass.demo.service.UserService;

/**
 * User: Zhang Kaitao
 * Date: 12-1-4 上午11:06
 * Version: 1.0
 */

@Service("UserService")
public class UserServiceImpl extends BaseService<UserModel, Integer> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    @Autowired
    @Qualifier("UserDao")
    @Override //重写通用父接口的setBaseDao()方法 
    public void setBaseDao(IBaseDao<UserModel, Integer> userDao) {
        this.baseDao = userDao; //将@UserDao的类注入到abstract BaseService(抽象通用service)的baseDao
        this.userDao = (UserDao) userDao; //将@UserDao的类注入到全局变量userDao
   
    
    }

    @Override  //分页查询所有UserQueryModel
    public Page<UserModel> query(int pn, int pageSize, UserQueryModel command) {
        //PageUtil 分页对象工具类 
    	//PageUtil.getPage(count本次查询所有记录数,分页下标(从第几行开始查询),list本次查询结果,pageSize每页显示行数)
    	return PageUtil.getPage
    			(userDao.countQuery(command),pn,userDao.query(pn, pageSize, command), pageSize);
    }

   
}