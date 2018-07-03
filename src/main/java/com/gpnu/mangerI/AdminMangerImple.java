package com.gpnu.mangerI;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gpnu.dao.AdminDao;
import com.gpnu.manger.AdminManger;
import com.gpnu.table.Admin;

@Service
public class AdminMangerImple   implements AdminManger {

	
    @Autowired
	private AdminDao adminDao;
	
	
	@Override
	public boolean findUserByAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.findUserByAdmin(admin);
	}


}
