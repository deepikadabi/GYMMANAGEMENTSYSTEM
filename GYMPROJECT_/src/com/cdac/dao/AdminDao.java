package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Admin;


public interface AdminDao {
	public void addAdmin(Admin admin);
	boolean loginAdmin(Admin admin);

	public void deleteAdmin(int aId );
	public void editAdmin(Admin admin);
	List<Admin> selectAll(int aId);
	String forgotPassword(String aEmail);
}
