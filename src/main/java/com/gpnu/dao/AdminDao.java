package com.gpnu.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.gpnu.table.Admin;

public interface AdminDao  {
    
	public boolean findUserByAdmin(Admin admin);
	
	
}
