package com.cdac.service;

import java.util.List;

import com.cdac.dto.Admin;


public interface AdminService {
	public void addAdmin(Admin admin);
	public void deleteAdmin(int aId );
	public void editAdmin(Admin admin);
	List<Admin> selectAll(int aId);
	public boolean loginAdmin(Admin admin);
	String forgotPassword(String aEmail);
}
