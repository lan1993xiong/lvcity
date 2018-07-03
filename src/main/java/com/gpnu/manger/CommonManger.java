package com.gpnu.manger;

import java.io.Serializable;
import java.util.List;

import com.gpnu.entity.Page;
import com.gpnu.table.Article;
import com.gpnu.table.Banar;

public interface CommonManger {
	
	public <T> void save(T t);
	
	public <T> List<T> findAll(String tableName);
	
	public <T> void delete(T t);
	
	public <T> T get(Class<T> T,Serializable id);
	
	public <T> T findClassByIdAndTableName(String tableName,String property, Integer propertyValue);

	
	 public <T> List<T> findListClassByPaging(String tableName,Page page);
}
