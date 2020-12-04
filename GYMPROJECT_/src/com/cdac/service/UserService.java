package com.cdac.service;

import java.util.List;

import com.cdac.dto.User;

public interface UserService {
	void addUser(User user);
	User loginUser(User user);
	void removeUser(int uId);
	void newUpdateUser(User user);
	User findUser(int uId);
	void modifyUser(User user);
	List<User> selectAll();
	boolean removePackage(int uId);
	String forgotPassword(String uEmail);
}
