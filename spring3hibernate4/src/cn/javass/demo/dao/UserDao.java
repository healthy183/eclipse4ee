package cn.javass.demo.dao;

import java.util.List;

import cn.javass.common.dao.IBaseDao;
import cn.javass.demo.model.UserModel;
import cn.javass.demo.model.UserQueryModel;

//user特有接口
public interface UserDao extends IBaseDao<UserModel, Integer> {
	
	//分页查询
    List<UserModel> query(int pn, int pageSize, UserQueryModel command);
    //分页对象总行数
    int countQuery(UserQueryModel command);

}
