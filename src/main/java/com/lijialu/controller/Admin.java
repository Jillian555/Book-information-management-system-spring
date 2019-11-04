package com.lijialu.controller;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lijialu.pojo.User;

@SuppressWarnings({ "restriction" })
@Controller
@RequestMapping("admin")
public class Admin {

	@Resource
	Map<String,User> usersMap; 
	
	@RequestMapping(value = "users",method = RequestMethod.GET)	
	public String showInfos(Model model) {
		//
		
		
		System.out.println("111111......");
		Collection<User> users= usersMap.values();
		model.addAttribute("users", users);		
		return "/message.jsp";
	}
	
	
}
