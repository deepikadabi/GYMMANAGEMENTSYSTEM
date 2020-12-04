package com.cdac.cntr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.GymPackage;
import com.cdac.dto.User;
import com.cdac.service.GymPackageService;



@Controller
public class GymPackageControll {
	@Autowired
	private GymPackageService gymPackageService;
	
	
	
/*	@RequestMapping(value="/pRegister.htm", method=RequestMethod.GET)
	public String register1(GymPackage gymPackage, ModelMap map, Model model) {
        model.addAttribute("rpackage", new GymPackage());
		map.put("rgym", new GymPackage());
		gymPackageService.addPackage(gymPackage);
		return "PackageRegister";
	}*/
}
