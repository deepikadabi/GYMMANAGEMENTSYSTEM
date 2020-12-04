package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Admin;
import com.cdac.dto.User;
import com.cdac.dto.UserPack;

public interface UserPackDao {
	public void addUserPack(UserPack userPack);
	List<UserPack> selectAll(int cartId);
	boolean selectUserInPack(int uId);


}
