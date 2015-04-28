package cn.javass.demo.dao.hibernate4;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.demo.dao.UserDao;
import cn.javass.demo.model.UserModel;
import cn.javass.demo.model.UserQueryModel;

/**
 * User: Zhang Kaitao
 * Date: 11-12-26 下午4:19
 * Version: 1.0
 */
@Repository("UserDao")
public class UserHibernate4DaoImpl extends BaseHibernateDao<UserModel, Integer> implements UserDao {

    private static final String HQL_LIST = "from UserModel ";
    private static final String HQL_COUNT = "select count(*) from UserModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where username like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    
    @Override    //重写UserDao方法   HQL_LIST_QUERY_CONDITION 根据userName来模糊查询 List<UserModel>
    public List<UserModel> query(int pn, int pageSize, UserQueryModel command) {
    //list()方法是从抽象父类BaseHibernateDao中重写过来的  
    //形式参数        arg0:hql语句      arg1:分页下标 arg2:一页多少行    arg3:可变参数 object[](这里是获得查询条件userName的值)
        return list(HQL_LIST_QUERY_ALL, pn,  pageSize, getQueryParam(command));
    }

    @Override    //重写UserDao方法  根据userName来模糊查询 List<UserModel>获得其总记录数字
    public int countQuery(UserQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(UserQueryModel command) {
        //TODO 改成全文索引  数据库的索引是useerName?
        String usernameLikeStr = "%" + command.getUsername() + "%";
        return new Object[]{usernameLikeStr};
    }

}
