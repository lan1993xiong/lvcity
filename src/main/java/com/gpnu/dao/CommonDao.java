package com.gpnu.dao;

import java.io.Serializable;
import java.util.List;

import com.gpnu.entity.Page;


public interface CommonDao {
	
	public <T> void save(T t);
	
	public <T> List<T> findAll(String tableName);
	
	public <T> void delete(T t);

	public <T> T get(Class<T> t, Serializable id);
	
	public <T> T findClassByIdAndTableName(String tableName,String property,Integer integer);
	
    public <T> List<T> findListClassByPaging(String tableName,Page page);
    

}
