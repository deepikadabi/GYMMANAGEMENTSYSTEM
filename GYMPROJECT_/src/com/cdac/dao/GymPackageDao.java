package com.cdac.dao;

import java.util.List;

import com.cdac.dto.GymPackage;


public interface GymPackageDao {
	void insertPackage(GymPackage gymPackage);
	void deletePackage(int pId);
	GymPackage selectPackage(int pId);
	void updatePackage(GymPackage gymPackage);
	List<GymPackage> selectAll();
	
}
