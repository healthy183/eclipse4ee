package cn.javass.common.dao.hibernate4;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.dao.util.ConditionQuery;
import cn.javass.common.dao.util.OrderBy;
import cn.javass.common.pagination.PageUtil;
import cn.javass.common.util.Assert;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author Zhang Kaitao
 *
 * @version 1.0, 2010-8-12
 * 通用的hibernateDao
 */
public abstract class BaseHibernateDao<M extends java.io.Serializable, PK extends java.io.Serializable> implements IBaseDao<M, PK> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseHibernateDao.class);

    private final Class<M> entityClass;
    private final String HQL_LIST_ALL;
    private final String HQL_COUNT_ALL;
    private final String HQL_OPTIMIZE_PRE_LIST_ALL;
    private final String HQL_OPTIMIZE_NEXT_LIST_ALL;
    private String pkName = null;

    //构造方法
    @SuppressWarnings("unchecked")
    public BaseHibernateDao() {
    	//通过发射获得当前调用本通用hibernateDao的javaBean实体类
        this.entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        //获得该javaBean所有全局变量(属性)?
        Field[] fields = this.entityClass.getDeclaredFields();
        for(Field f : fields) {
        	//获取标记了@Id的全局变量(即数据库主键)
            if(f.isAnnotationPresent(Id.class)) {
            	//付给本类的全局变量
                this.pkName = f.getName();
            }
        }
        
        Assert.notNull(pkName);//断言一下
        //TODO @Entity name not null
        //根据主键降序查询对象集合
        HQL_LIST_ALL = "from " + this.entityClass.getSimpleName() + " order by " + pkName + " desc";
        //升序查询大于主键的对象集合
        HQL_OPTIMIZE_PRE_LIST_ALL = "from " + this.entityClass.getSimpleName() + " where " + pkName + " > ? order by " + pkName + " asc";
        //降序查询小于主键的对象集合
        HQL_OPTIMIZE_NEXT_LIST_ALL = "from " + this.entityClass.getSimpleName() + " where " + pkName + " < ? order by " + pkName + " desc";
        //查询本类总行数
        HQL_COUNT_ALL = " select count(*) from " + this.entityClass.getSimpleName();
    }
        
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到 配置声明式事务需谨慎 
        return sessionFactory.getCurrentSession();
    }

   
    
    @SuppressWarnings("unchecked")
    @Override  
    public PK save(M model) {
        return (PK) getSession().save(model);
    }

    @Override
    public void saveOrUpdate(M model) {
        getSession().saveOrUpdate(model);
    }

    @Override
    public void update(M model) {
        getSession().update(model);

    }

    @Override
    public M merge(M model) {
       return (M)getSession().merge(model);
    }

    @Override
    public void delete(PK id) {
        getSession().delete(this.get(id));

    }

    @Override
    public void deleteObject(M model) {
        getSession().delete(model);

    }

    @Override
    public boolean exists(PK id) {
        return get(id) != null;
    }

    @Override
    public M get(PK id) {
        return (M)getSession().get(this.entityClass, id);
    }

    @Override
    public int countAll() {
    	//从hibernate3.2开始执行count函数的hql返回的都必须是long
        Long total = aggregate(HQL_COUNT_ALL);
        return total.intValue();//转换,但跟int a =(int)total有什么区别?;
    }


    @Override //根据主键降序查询所有指定javaBean对象List
    public List<M> listAll() {
        return list(HQL_LIST_ALL);
    }

    @Override  //根据主键降序分页查询
    public List<M> listAll(int pn, int pageSize) {
        return list(HQL_LIST_ALL, pn, pageSize);
    }
    
    @Override  //上一页
    public List<M> pre(PK pk, int pn, int pageSize) {
        if(pk == null) {
            return list(HQL_LIST_ALL, pn, pageSize);
        }
        //升序分页查询大于当前主键的javaBeanList
        List<M> result = list(HQL_OPTIMIZE_PRE_LIST_ALL, 1, pageSize, pk);
        //倒序，重排
        Collections.reverse(result);
        return result;
    }
    @Override //下一页
    public List<M> next(PK pk, int pn, int pageSize) {
        if(pk == null) {
        	//根据主键降序分页查询
            return list(HQL_LIST_ALL, pn, pageSize);
        }//小于当前主键升序查询
        return list(HQL_OPTIMIZE_NEXT_LIST_ALL, 1, pageSize, pk);
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }
    
    //传入hql,可变参数,返回list的第一个对象，然后返回？？？不懂 ((Number) list.get(0)).longValue()
    protected long getIdResult(String hql, Object... paramlist) {
        long result = -1;
        List<?> list = list(hql, paramlist);
        if (list != null && list.size() > 0) {
            return ((Number) list.get(0)).longValue();
        }
        return result;
    }

    protected List<M> listSelf(final String hql, final int pn, final int pageSize, final Object... paramlist) {
        return this.<M> list(hql, pn, pageSize, paramlist);
    }


    /**
     * for in
     */
    //分页查询，直接传入开始下标和长度
    //带Map<String, Collection<?>>的查询条件并使用in()函数的hql,
    @SuppressWarnings("unchecked")
    protected <T> List<T> listWithIn(final String hql,final int start, final int length,
    		final Map<String, Collection<?>> map, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        for (Entry<String, Collection<?>> e : map.entrySet()) {
            query.setParameterList(e.getKey(), e.getValue());
        }
        if (start > -1 && length > -1) {
            query.setMaxResults(length);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        List<T> results = query.list();
        return results;
    }

    @SuppressWarnings("unchecked")  //普通的分页查询方法
    protected <T> List<T> list(final String hql, final int pn, final int pageSize, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);//paramlist[]值的顺序应该要和hql中的?顺序相同
       
        //有个bug? pageSize==0的时候, query.setMaxResults(0)只是查询0行?还是把变成全查?
        if (pn > -1 && pageSize > -1) {
            query.setMaxResults(pageSize);//设置每页查询多少页
            //获取从第几行开始查询的static静态方法  (pageNumber - 1) * pageSize
            int start = PageUtil.getPageStart(pn, pageSize);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        if (pn < 0) {
            query.setFirstResult(0);
        }
        List<T> results = query.list();
        return results;
    }

   
    /*根据查询条件返回唯一一条记录 可返回一条记录或者调用count(*)函数的时候返回long */
    @SuppressWarnings("unchecked")
    protected <T> T unique(final String hql, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        return (T) query.setMaxResults(1).uniqueResult();
    }

    /**
     * for in
     */
    /* 用于带Map<String, Collection<?>>的查询条件并使用in()函数的hql,可返回一条记录或者调用count(*)函数的时候返回long */
    @SuppressWarnings("unchecked")
    protected <T> T aggregate(final String hql, final Map<String, Collection<?>> map, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        if (paramlist != null) { //判断可变参数是否为空
            setParameters(query, paramlist);//设置值
            //for循环map 获得map的key和map中的 Collectio,在迭代设置值(要使用hibernate的hql命名参数)
            for (Entry<String, Collection<?>> e : map.entrySet()) {
                query.setParameterList(e.getKey(), e.getValue());
            }
        }
        /*个人觉得if (paramlist != null)里是不是应该将
        for (Entry<String, Collection<?>> e : map.entrySet())并列在一起,
   		因为paramlist的null与否,不影响map的for*/ 
        /**if (paramlist != null) { //判断可变参数是否为空
            setParameters(query, paramlist);//设置值
            //for循环map 获得map的key和map中的 Collectio,在迭代设置值(要使用hibernate的hql命名参数)
        }
        if(map !=null){
        	for (Entry<String, Collection<?>> e : map.entrySet()) {
                query.setParameterList(e.getKey(), e.getValue());
            }
        }   * */
        return (T) query.uniqueResult();
        
       
  }
        
    @SuppressWarnings("unchecked")//查询总记录数字
    protected <T> T aggregate(final String hql, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        return (T) query.uniqueResult();

    }


    /**使用hql执行批处理语句.如 之间insert, update, delete 等. 返回影响行数  */
    protected int execteBulk(final String hql, final Object... paramlist) {
        Query query = getSession().createQuery(hql);
        setParameters(query, paramlist);
        Object result = query.executeUpdate();
        return result == null ? 0 : ((Integer) result).intValue();
    }
    
    /**使用标准sql执行批处理语句.如 之间insert, update, delete 等. 返回影响行数  */
    protected int execteNativeBulk(final String natvieSQL, final Object... paramlist) {
        Query query = getSession().createSQLQuery(natvieSQL);
        setParameters(query, paramlist);
        Object result = query.executeUpdate();
        return result == null ? 0 : ((Integer) result).intValue();
    }

    //只传入基本hql和可变参数 返回从第一行开始查询的List
    protected <T> List<T> list(final String sql, final Object... paramlist) {
        return list(sql, -1, -1, paramlist);
    }
        
    @SuppressWarnings("unchecked")//待研究
    public <T> List<T> listByNative(final String nativeSQL, final int pn, final int pageSize,
            final List<Entry<String, Class<?>>> entityList, 
            final List<Entry<String, Type>> scalarList, final Object... paramlist) {

        SQLQuery query = getSession().createSQLQuery(nativeSQL);
        if (entityList != null) {
            for (Entry<String, Class<?>> entity : entityList) {
                query.addEntity(entity.getKey(), entity.getValue());
            }
        }
        if (scalarList != null) {
            for (Entry<String, Type> entity : scalarList) {
                query.addScalar(entity.getKey(), entity.getValue());
            }
        }

        setParameters(query, paramlist);

        if (pn > -1 && pageSize > -1) {
            query.setMaxResults(pageSize);
            int start = PageUtil.getPageStart(pn, pageSize);
            if (start != 0) {
                query.setFirstResult(start);
            }
        }
        List<T> result = query.list();
        return result;
    }
        
    @SuppressWarnings("unchecked") //待研究
    protected <T> T aggregateByNative(final String natvieSQL, final List<Entry<String, Type>> scalarList, final Object... paramlist) {
        SQLQuery query = getSession().createSQLQuery(natvieSQL);
        if (scalarList != null) {
            for (Entry<String, Type> entity : scalarList) {
                query.addScalar(entity.getKey(), entity.getValue());
            }
        }

        setParameters(query, paramlist);

        Object result = query.uniqueResult();
        return (T) result;
    }
        
    @SuppressWarnings("unchecked") //待研究
    public <T> List<T> list(ConditionQuery query, OrderBy orderBy, final int pn, final int pageSize) {
        Criteria criteria = getSession().createCriteria(this.entityClass);
        query.build(criteria);
        orderBy.build(criteria);
        int start = PageUtil.getPageStart(pn, pageSize);
        if(start != 0) {
            criteria.setFirstResult(start);
        }
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> list(Criteria criteria) {
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public <T> T unique(Criteria criteria) {
        return (T) criteria.uniqueResult();
    }

    public <T> List<T> list(DetachedCriteria criteria) {
        return list(criteria.getExecutableCriteria(getSession()));
    }

    @SuppressWarnings("unchecked")
    public <T> T unique(DetachedCriteria criteria) {
        return (T) unique(criteria.getExecutableCriteria(getSession()));
    }

    protected void setParameters(Query query, Object[] paramlist) {
        if (paramlist != null) {
            for (int i = 0; i < paramlist.length; i++) {
                if(paramlist[i] instanceof Date) {
                    //TODO 难道这是bug 使用setParameter不行？？
                    query.setTimestamp(i, (Date)paramlist[i]);
                } else {
                    query.setParameter(i, paramlist[i]);
                }
            }
        }
    }

        
}
