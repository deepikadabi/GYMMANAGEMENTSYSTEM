package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.GymPackageDao;
import com.cdac.dao.UserDao;
import com.cdac.dto.GymPackage;
import com.cdac.dto.User;
@Service
public class GymPackageServiceImple implements GymPackageService {
	
	@Autowired
	private GymPackageDao gymPackageDao;

	@Override
	public void addPackage(GymPackage gymPackage) {
		// TODO Auto-generated method stub
		gymPackageDao.insertPackage(gymPackage);
		
	}

	@Override
	public void removePackage(int pId) {
		// TODO Auto-generated method stub
		
		gymPackageDao.deletePackage(pId);
	}

	@Override
	public GymPackage findPackage(int pId) {
		// TODO Auto-generated method stub
		return gymPackageDao.selectPackage(pId);
	}

	@Override
	public void modifyPackage(GymPackage gymPackage) {
		// TODO Auto-generated method stub
		gymPackageDao.updatePackage(gymPackage);
	}

	@Override
	public List<GymPackage> selectAll() {
		// TODO Auto-generated method stub
		return gymPackageDao.selectAll();
	}

}
