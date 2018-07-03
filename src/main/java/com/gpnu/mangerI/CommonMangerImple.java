package com.gpnu.mangerI;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpnu.dao.CommonDao;
import com.gpnu.entity.Page;
import com.gpnu.manger.CommonManger;

@Service("commonMangerImple")
public class CommonMangerImple implements CommonManger{
    
	@Autowired
	private CommonDao commonDao;
	
	@Override
	public <T> void save(T t) {
		// TODO Auto-generated method stub
		commonDao.save(t);
	}

	@Override
	public <T> List<T> findAll(String tableName) {
		// TODO Auto-generated method stub
		return commonDao.findAll(tableName);
	}

	@Override
	public <T> void delete(T t) {
		// TODO Auto-generated method stub
		commonDao.delete(t);
	}

	@Override
	public <T> T get(Class<T> t, Serializable id) {
		// TODO Auto-generated method stub
		return commonDao.get(t, id);
	}


	
	@Override
	public <T> List<T> findListClassByPaging(String tableName, Page page) {
		// TODO Auto-generated method stub
		return commonDao.findListClassByPaging(tableName, page);
	}

	@Override
	public <T> T findClassByIdAndTableName(String tableName, String property, Integer propertyValue) {
		// TODO Auto-generated method stub
		return commonDao.findClassByIdAndTableName(tableName, property, propertyValue);
	}
	

}
