package com.pabitra.online_shopping.service.impl;

import com.pabitra.online_shopping.dao.UsersDao;
import com.pabitra.online_shopping.entity.UsersEntity;
import com.pabitra.online_shopping.service.UsersService;
import com.pabitra.online_shopping.utility.Application;

public class UsersServiceImpl implements UsersService{
	public int register(UsersEntity entity) {
		UsersDao dao = Application.getUsersDao();
		return(dao.saveUser(entity));
	}
	
	public UsersEntity login(String phone, String password) {
		UsersDao dao = Application.getUsersDao();
		UsersEntity user = dao.verifyUser(phone, password);
		return user;
	}
	
	public boolean isDuplicateUser(String phone) {
		System.out.println("UsersServiceImpl.isDuplicateUser()");
		UsersDao dao = Application.getUsersDao();
		if(dao.isDuplicateUser(phone)) {
			System.out.println("isDuplicate() method return value = true");
			return true;
		}
		System.out.println("isDuplicate() method return value = false");
		return false;
	}
}
