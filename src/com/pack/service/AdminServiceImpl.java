package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.AdminDao;
import com.pack.entity.Login;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String loginAdmin(Login login) {
		// TODO Auto-generated method stub
		
		System.out.println("inside service");
		String l=null;
		l=adminDao.loginAdmin(login);
		return l;
	}

}
