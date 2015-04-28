package cn.javass.common.dao;

import java.util.List;

public interface IBaseDao<M extends java.io.Serializable, PK extends java.io.Serializable> {
    
    public PK save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    //public void merge(M model);
    public M merge(M model);
    
    //根据id删除对象
    public void delete(PK id);

    public void deleteObject(M model);

    public M get(PK id);
    
    public int countAll();

    public List<M> listAll();
    	
    public List<M> listAll(int pn, int pageSize);
    
    //下一页
    public List<M> pre(PK pk, int pn, int pageSize);
    //上一页
    public List<M> next(PK pk, int pn, int pageSize);
    
    //根据主键判断对象是否存在
    boolean exists(PK id);
    
    public void flush();
    
    public void clear();



}