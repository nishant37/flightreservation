package com.nishant.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nishant.flightreservation.entities.User;
import com.nishant.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		
		return "login/registerUser";
	}

	@RequestMapping(value="/registerUser",method=RequestMethod.GET)
	public String register(@ModelAttribute("user") User user) {
		
		userRepository.save(user);
		
		return "login/login";
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam(value="email")String email, @RequestParam(value="password") String password, ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg","Invalid user name or password. Please try again");
		}
		return "login/login";
	}
	
	
}
