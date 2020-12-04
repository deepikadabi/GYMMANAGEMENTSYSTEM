package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.UserDao;
import com.cdac.dto.User;

@Service

public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User loginUser(User user) {
		return userDao.loginUser(user);
	}

	@Override
	public void removeUser(int uId) {
		userDao.deleteUser(uId);
	}

	@Override
	public User findUser(int uId) {
		// TODO Auto-generated method stub
		return userDao.selectUser(uId);
	}

	@Override
	public void modifyUser(User user) {
			userDao.updateUser(user);
		
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public void newUpdateUser(User user) {
		userDao.newUpdate(user);
		
	}

	@Override
	public boolean removePackage(int uId) {
		// TODO Auto-generated method stub
		return userDao.removePack(uId);
	}

	@Override
	public String forgotPassword(String uEmail) {
		// TODO Auto-generated method stub
		return userDao.forgotPassword(uEmail);
	}

	
}
