package com.springjdbc.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public interface BaseDao<T> {

	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void deleteById(Serializable id);

	public void deleteAll();

	public void batchSave(List<T> list);

	public void batchUpdate(List<T> list);

	public void batchDelete(List<T> list);

	public T findById(Serializable id);

	public List<T> findAll();

	public QueryResult<T> findByPage(int pageNo, int pageSize);

	public QueryResult<T> findByPage(int pageNo, int pageSize, Map<String, String> where);

	public QueryResult<T> findByPage(int pageNo, int pageSize, LinkedHashMap<String, String> orderby);

	public QueryResult<T> findByPage(int pageNo, int pageSize, Map<String, String> where,
			LinkedHashMap<String, String> orderby);
}
