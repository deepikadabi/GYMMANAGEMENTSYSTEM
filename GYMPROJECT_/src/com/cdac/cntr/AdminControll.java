package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Admin;
import com.cdac.dto.GymPackage;
import com.cdac.dto.User;
import com.cdac.service.AdminService;
import com.cdac.service.GymPackageService;
import com.cdac.service.UserService;

@Controller
public class AdminControll {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private GymPackageService gymPackageService;
	@Autowired
	private UserService userService;
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping(value="/aRegister.htm", method=RequestMethod.GET)
	public String register(Admin admin, ModelMap map) {

		map.put("admin", new Admin());
		adminService.addAdmin(admin);
		return "AdminRegister";
	}
	
	@RequestMapping(value="/aIndexLogin.htm", method= RequestMethod.GET)
	public String register2(Admin admin, ModelMap map) {
		System.out.println(admin);
		map.put("adminLog", new Admin());
		System.out.println("frst login");
		return "AdminLogin";
	}
	
	
	@RequestMapping(value="/aLogin.htm", method= RequestMethod.POST)
	public String login1(Admin admin, ModelMap map, HttpSession session) {
		System.out.println(admin);
		boolean b = adminService.loginAdmin(admin);
		if(b) {
			session.setAttribute("LoggedAdmin", admin);
			System.out.println(((Admin)session.getAttribute("LoggedAdmin")).toString());

			return "AdminHome";
		}
		session.setAttribute("err", "Invalid Credential...!!!");
	
		map.put("adminLog", new Admin());
		System.out.println("sec login");

		return "AdminLogin";
	}
	
	@RequestMapping(value="/AdminLogout.htm", method= RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	@RequestMapping(value="/AddUserViaAdmin.htm")
	public String addMember(User user) {
		return "AddMemberAdmin";	
	}
	
	
	@RequestMapping(value="/aAddingMember.htm", method=RequestMethod.GET)
	public String register(User user, ModelMap map) {

		map.put("user", new User());
		userService.addUser(user);
		return "AddMemberAdmin";
	}
	
	@RequestMapping(value = "/MemberList.htm",method = RequestMethod.GET)
	public String allMember(ModelMap map,HttpSession session) {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		List<User> li = userService.selectAll();
		System.out.println(li);
		map.put("uList", li);
		
		return "AllUserList";
	}
	
	
	@RequestMapping(value = "/user_delete.htm",method = RequestMethod.GET)
	public String userDelete(@RequestParam int uId,ModelMap map,HttpSession session) {
		System.out.println(uId);
		userService.removeUser(uId); 
		
		/*
		 * int userId = ((User)session.getAttribute("user")).getuId();
		 */		
		List<User> li = userService.selectAll();
		map.put("uList", li);
		return "AllUserList";
	}
	
	
	@RequestMapping(value = "/user_update.htm",method = RequestMethod.GET)
	public String expenseUpdateForm(@RequestParam int uId ,ModelMap map) {
		System.out.println(uId);
		User u = userService.findUser(uId);
		map.put("user", u);
		System.out.println(u);

		return "MemberUpdate";
	}
	
	@RequestMapping(value = "/user_update_data.htm",method = RequestMethod.POST)
	public String expenseUpdate(User user,ModelMap map,HttpSession session) {
		
		
		System.out.println("updateeeeeeeeee");
		System.out.println(user.toString());
		//int uId = ((User)session.getAttribute("user")).getuId(); 
		System.out.println(user.toString());
		//System.out.println(uId +"--------------------");
		user.setuId(user.getuId());
		userService.modifyUser(user);;
		System.out.println("updateeeedsddfddeeeeee");
		
		List<User> li = userService.selectAll();
		map.put("uList", li);
		return "AllUserList";
	}
	
	
	@RequestMapping(value="/registerPackage.htm", method=RequestMethod.GET)
	public String register(GymPackage gymPackage, ModelMap map) {

		System.out.println("hiiiiiiiiiii......");
		
		return "PackageRegister";
	}
	
	@RequestMapping(value="/pRegister.htm", method=RequestMethod.GET)
	public String register1(GymPackage gymPackage, ModelMap map, Model model) {
        model.addAttribute("rpackage", new GymPackage());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		map.put("gymPackage", new GymPackage());
		gymPackageService.addPackage(gymPackage);
		return "AdminHome";
	}
	
	
	@RequestMapping(value = "/packageList.htm",method = RequestMethod.GET)
	public String allPack(ModelMap map,HttpSession session) {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		List<GymPackage> li = gymPackageService.selectAll();
		System.out.println(li);
		map.put("pList", li);
		
		return "AllPackList";
	}
	
	
	@RequestMapping(value = "/pack_delete.htm",method = RequestMethod.GET)
	public String packDelete(@RequestParam int pId,ModelMap map,HttpSession session) {
		System.out.println(pId);
		gymPackageService.removePackage(pId);
		System.out.println("++++++++++++++++++++++++++++++++++");
		
		/*
		 * int userId = ((User)session.getAttribute("user")).getuId();
		 */		
		List<GymPackage> li = gymPackageService.selectAll();
		map.put("pList", li);
		return "AllPackList";
	}
	
	
	@RequestMapping(value = "/pack_update.htm",method = RequestMethod.GET)
	public String packUpdateForm(@RequestParam int pId ,ModelMap map) {
		GymPackage u = gymPackageService.findPackage(pId);
		System.out.println("in update.......");
		
		map.put("gymPackage", u);
		System.out.println(u);

		return "PackageUpdate";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/pack_update_data.htm",method = RequestMethod.POST)
	public String packageUpdate(GymPackage gymPackage,ModelMap map,HttpSession session) {
		
		
		System.out.println("updateeeeeeeeee");
		System.out.println(gymPackage.toString());
		//int uId = ((User)session.getAttribute("user")).getuId(); 
		
		//System.out.println(uId +"--------------------");
		gymPackage.setpId(gymPackage.getpId());
		gymPackageService.modifyPackage(gymPackage);;
		System.out.println("updateeeedsddfddeeeeee");
		
		List<GymPackage> li = gymPackageService.selectAll();
		map.put("pList", li);
		return "AllPackList";
	}
	
	@RequestMapping(value = "/UserListWithPackage.htm",method = RequestMethod.GET)
	public String userWithPack(ModelMap map,HttpSession session) {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		List<User> li = userService.selectAll();
		System.out.println("9999999999999999999999999999999");
		
		System.out.println(li);
		map.put("uList", li);
		
		return "UserWithPack";
	}
	
	
	@RequestMapping(value = "/removeFromMemberShip.htm",method = RequestMethod.GET)
	public String removeMemberFromPack(@RequestParam int uId,ModelMap map,HttpSession session) {
		System.out.println(uId);
		userService.removePackage(uId); 
		List<User> li = userService.selectAll();
		map.put("uList", li);
		return "UserWithPack";
	}
	
	@RequestMapping(value = "/forgot_password.htm",method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String aEmail,ModelMap map) {		
		String pass = adminService.forgotPassword(aEmail);
		String msg = "you are not registered";
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("dabideepika1204@gmail.com");  
	        message.setTo(aEmail);  
	        message.setSubject("Your password");  
	        message.setText(pass);  
	        //sending message   
	        mailSender.send(message);
			msg = "check the mail for password";
		}
		map.put("msg", msg);
		return "info";
	}
}
