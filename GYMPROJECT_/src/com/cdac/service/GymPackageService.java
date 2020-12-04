package com.cdac.service;

import java.util.List;

import com.cdac.dto.GymPackage;
import com.cdac.dto.User;

public interface GymPackageService {
	void addPackage(GymPackage gymPackage);
	void removePackage(int pId);

	GymPackage findPackage(int pId);
	void modifyPackage(GymPackage gymPackage);
	List<GymPackage> selectAll();
}
