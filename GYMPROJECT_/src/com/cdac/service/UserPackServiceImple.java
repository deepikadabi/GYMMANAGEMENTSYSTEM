package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.UserPackDao;
import com.cdac.dto.UserPack;
@Service
public class UserPackServiceImple implements UserPackService {

	@Autowired
	private UserPackDao userpackdao;
	
	@Override
	public void addUserPack(UserPack userPack) {
		// TODO Auto-generated method stub
		userpackdao.addUserPack(userPack);
		
	}

	@Override
	public List<UserPack> selectAll(int cartId) {
		// TODO Auto-generated method stub
		return userpackdao.selectAll(cartId);
	}

}
