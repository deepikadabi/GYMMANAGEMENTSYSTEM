package com.cdac.service;

import java.util.List;

import com.cdac.dto.UserPack;

public interface UserPackService {
	public void addUserPack(UserPack userpack);
	List<UserPack> selectAll(int cartId);


}
