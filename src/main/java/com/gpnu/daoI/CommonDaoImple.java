package com.gpnu.daoI;

import static org.hibernate.criterion.Example.create;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gpnu.dao.CommonDao;
import com.gpnu.entity.Page;
import com.gpnu.table.Admin;

@Transactional
public class CommonDaoImple implements CommonDao {

	private static final Logger log = LoggerFactory.getLogger(CommonDaoImple.class);
	// property constants
    @Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	@Override
	public <T> void save(T t) {
		// TODO Auto-generated method stub
		log.debug("saving T instance");
		try {
			Session session  = sessionFactory.getCurrentSession();
			session.saveOrUpdate(t);
			session.flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}



	@Override
	public <T> List<T> findAll(String tableName) {
		// TODO Auto-generated method stub
		
		String hql = "From "+tableName;
		List<T> lsit = getCurrentSession().createQuery(hql).list();
		return lsit;
	}

	@Override
	public <T> void delete(T t) {
		// TODO Auto-generated method stub
		Session session  = sessionFactory.getCurrentSession();
		session.delete(t);
		session.flush();

	}

	@Override
	public <T> T get(Class<T> t, Serializable id) {
		// TODO Auto-generated method stub
		return (T) sessionFactory.getCurrentSession().get(t, id);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T findClassByIdAndTableName(String tableName, String idName, Integer id) {
		// TODO Auto-generated method stub
        T t = null;
		String hql = "from "+tableName+" where "+ idName +"=:id";
		 List<T> list = new ArrayList<T>();
		 list= sessionFactory.getCurrentSession().createQuery(hql)
		                                  .setParameter("id", id)
		                                  .list();
		 if(list.size() != 0){
			 t = list.get(0);
		 }
		 
      
		return t;
	}
     
	@Override
	public <T> List<T> findListClassByPaging(String tableName, Page page) {
		// TODO Auto-generated method stub
		String hql = "from " + tableName;
		List<T> list = (List<T>) sessionFactory.getCurrentSession().createQuery(hql).list();
		int row = 18;
		Query query  = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult((page.getPageNow()-1) * row);
        query.setMaxResults(list.size());
        List<T> targetList = query.list();
		return targetList;
	}}
