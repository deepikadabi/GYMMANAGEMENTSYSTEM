package com.cdac.dao;

import java.util.List;

import com.cdac.dto.User;

public interface UserDao {
	void insertUser(User user);
	User loginUser(User user);
	void deleteUser(int uId);
	User selectUser(int uId);
	void newUpdate(User user);
	void updateUser(User user);
	boolean removePack(int uId);
	List<User> selectAll();
	String forgotPassword(String uEmail);
	
}
