package com.kang.service;


import java.util.Collection;
import java.util.List;

import com.gialen.kang.tool.Page;
import com.kang.dao.IbaseDAO;


public abstract class 
	BaseHibernateService<M extends java.io.Serializable, PK extends java.io.Serializable> 
		implements IbaseService<M, PK> {

	 protected IbaseDAO<M, PK> baseDAO;
	 public abstract void setBaseDAO(IbaseDAO<M, PK> baseDAO);

	 public void saveAll(List<?> list){
		 baseDAO.saveAll(list);
	 }
	 
	 
	@Override
	public void save(Object model) {
		baseDAO.save(model);
	}

	@Override
	public void saveOrUpdate(Object model) {
		baseDAO.saveOrUpdate(model);		
	}

	@Override
	public void update(Object model) {
		baseDAO.update(model);		
	}

	@Override
	public M merge(M model) {
		return baseDAO.merge(model);
	}

	@Override
	public void delete(PK id) {
		baseDAO.deleteById(id);		
	}

	@Override
	public void deleteObject(Object model) {
		baseDAO.delete(model);
	}

	@Override
	public M get(PK id) {
		return baseDAO.get(id);
	}

	@Override
	public M load(PK id){
		return baseDAO.load(id);
	}
	
	@Override
	public int countAll() {
		return baseDAO.countAll();
	}

	@Override
	public List<M> findAll() {
		return baseDAO.findAll();
	}

	@Override
	public List<M> findAll(int pn, int pageSize) {
		return baseDAO.findAll(pn, pageSize);
	}
	
	@Override
	public Page findAllForPage(int pn) {
		return baseDAO.findAllForPage(pn);
	}
	
	@Override
	public Page findAllForPage(int pn, int pageSize) {
		return baseDAO.findAllForPage(pn,pageSize);
	}
	
	@Override
	public List findByProperty(String propertyName,Object object){
		return baseDAO.findByProperty(propertyName, object);
	}
	
	
	
	@Override
	public Page pre(PK pk, int pn, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page next(PK pk, int pn, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page pre(PK pk, int pn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page next(PK pk, int pn) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
