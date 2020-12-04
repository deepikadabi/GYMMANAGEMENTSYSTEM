package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.GymPackage;
import com.cdac.dto.User;
import com.cdac.dto.UserPack;
import com.cdac.service.GymPackageService;
import com.cdac.service.UserPackService;
import com.cdac.service.UserService;

@Controller
public class UserControll {
	@Autowired
	private UserService userService;
	@Autowired
	private GymPackageService gymPackageService;
	
	@Autowired
	private MailSender mailSender;
	@RequestMapping(value="/uRegister.htm", method=RequestMethod.GET)
	public String register(User user, ModelMap map) {

		map.put("user", new User());
		userService.addUser(user);
		return "UserRegister";
	}
	
	@RequestMapping(value="/uLogin.htm", method= RequestMethod.GET)
	public String register2(User user, ModelMap map) {
		System.out.println(user);
		map.put("userLog", new User());
		System.out.println("frst login");
		return "UserLogin";
	}
	
	@RequestMapping(value="/UserLogout.htm", method= RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	@RequestMapping(value="/uIndexLogin.htm", method= RequestMethod.POST)
	public String login1(User user, ModelMap map, HttpSession session) {
		System.out.println(user);
		User user1 = userService.loginUser(user);
		if(user1 != null) {
			session.setAttribute("LoggedUser", user1);
			System.out.println("Hieeeeeeeeee");
			System.out.println(user1);
			user = user1;
			return "UserHome";
		}
		session.setAttribute("err", "Invalid Credential...!!!");
		map.put("userLog", new User());
		System.out.println("sec login");
		System.out.println(user);

		return "UserLogin";
	}

	
	@RequestMapping(value = "/showDetails.htm",method = RequestMethod.GET)
	public String expenseUpdateForm(User user, HttpSession session,ModelMap map) {
		
		System.out.println("in showwwww");
		System.out.println(((User)session.getAttribute("LoggedUser")).toString());
		int uId = ((User)session.getAttribute("LoggedUser")).getuId();

		System.out.println(uId);
		User u = userService.findUser(uId);
		System.out.println(u.toString());
		//map.put("user", u);
		//System.out.println(u);
		map.put("userLog", u);
		System.out.println("frst login");
		System.out.println(((User)session.getAttribute("LoggedUser")).toString());
		
		return "UserProfile";
	}
	
	
	@RequestMapping(value = "/updateProfilViaUser.htm",method = RequestMethod.GET)
	public String expenseUpdateForm(ModelMap map, HttpSession session) {
		int uId = ((User)session.getAttribute("LoggedUser")).getuId();
		System.out.println(uId);
		System.out.println("in updateeee");
		User u = userService.findUser(uId);
	
		map.put("user", u);
		System.out.println(u);

		return "UpdateProViaUser";
	}
	
	
	
	@RequestMapping(value = "/UpdatedDetails.htm",method = RequestMethod.POST)
	public String expenseUpdate(User user,ModelMap map,HttpSession session) {
		
		
		System.out.println("updateeeeeeeeee");
		System.out.println(user.toString());
		//int uId = ((User)session.getAttribute("user")).getuId(); 
		System.out.println(user.toString());
		//System.out.println(uId +"--------------------");
		int uId = ((User)session.getAttribute("LoggedUser")).getuId();
		//user.setuId(user.getuId());
		user.setuId(uId);
		userService.newUpdateUser(user);;
		System.out.println("updateeeedsddfddeeeeee");
		
		List<User> li = userService.selectAll();
		map.put("uList", li);
		return "UserHome";
	}
	
	

	
	@RequestMapping(value = "/available_package.htm",method = RequestMethod.GET)
	public String allPack(ModelMap map,HttpSession session) {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		List<GymPackage> li = gymPackageService.selectAll();
		System.out.println(li);
		map.put("pList", li);
		return "AvailablePackList";
	}
	
	
	@RequestMapping(value="/userPack.htm", method=RequestMethod.GET)
	public String register(@RequestParam int pId, User user, ModelMap map, HttpSession session) {
		System.out.println(pId);
		int logId = ((User)session.getAttribute("LoggedUser")).getuId();
		user = (User) session.getAttribute("LoggedUser");
		
		System.out.println("in userpackk jjjjjjjjjjjjjjjjjjjjj");
		System.out.println(user.toString());
		System.out.println(logId);
		System.out.println("------------------------------");
		GymPackage gymPackage = gymPackageService.findPackage(pId);
		user.setGymPackage(gymPackage);
		System.out.println("+++++++++++++++++++++++++");
		userService.modifyUser(user);
		System.out.println(user.toString());
		session.setAttribute("curpId", pId);
		System.out.println(gymPackage.toString());
		
		
//		userPack.setUser(user);
//		userPack.setGymPackage(gp);
//		userPackService.addUserPack(userPack);
		/*
		 * User u = userService.findUser(uId); map.put("user", u);
		 * System.out.println(u); map.put("userPack", new UserPack());
		 * userPackService.addUser(userPack);
		 */
		return "UserHome";
	}
	
	
	
	@RequestMapping(value ="/CurrPackage.htm", method=RequestMethod.POST)
	public String CurrentPackage(ModelMap map, HttpSession session) {
		int uId = ((User)session.getAttribute("LoggedUser")).getuId();
		System.out.println(uId);
		System.out.println("###############");
		

		return "AvailablePackList";
	}
	@RequestMapping(value ="/CurrPackage.htm", method=RequestMethod.GET)
	public String CurrentPackage1(ModelMap map, HttpSession session) {
		GymPackage gymPackage = ((User)session.getAttribute("LoggedUser")).getGymPackage();
		
		int pId = gymPackage.getpId();
		System.out.println("###############");
		
		GymPackage g = gymPackageService.findPackage(pId);
		System.out.println(g.toString());
		//map.put("user", u);
		//System.out.println(u);
		map.put("packLog", g);
		System.out.println("frst login");
		System.out.println(((User)session.getAttribute("LoggedUser")).toString());
		

		return "CurrentPackage";
	}
	
	@RequestMapping(value = "/CurrPackUpdate.htm",method = RequestMethod.GET)
	public String currPackUpdate(ModelMap map, HttpSession session) {
		int uId = ((User)session.getAttribute("LoggedUser")).getuId();
		System.out.println(uId);
		System.out.println("in updateeee");
		int pId = ((User)session.getAttribute("LoggedUser")).getGymPackage().getpId();
		GymPackage u = gymPackageService.findPackage(pId);
	
		map.put("user", u);
		System.out.println(u);

		return "CurrentPackage";
	}
	
	
	
	@RequestMapping(value = "/user_password.htm",method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String uEmail,ModelMap map) {		
		String pass = userService.forgotPassword(uEmail);
		String msg = "you are not registered";
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("dabideepika1204@gmail.com");  
	        message.setTo(uEmail);  
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
