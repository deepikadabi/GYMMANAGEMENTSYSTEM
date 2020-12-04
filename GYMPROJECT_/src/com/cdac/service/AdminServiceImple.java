package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.AdminDao;
import com.cdac.dto.Admin;

@Service

public class AdminServiceImple implements AdminService {

	@Autowired
	private AdminDao adminDao;
	@Override
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);

	}
	@Override
	public String forgotPassword(String aEmail) {
		return adminDao.forgotPassword(aEmail);
	}
	@Override
	public void deleteAdmin(int aId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> selectAll(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.loginAdmin(admin);
	}

	

}
