package com.lijialu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lijialu.pojo.Book;
import com.lijialu.pojo.User;
import com.lijialu.service.BookService;
import com.lijialu.vo.UserValid;

@SuppressWarnings({ "restriction" })
@Controller
public class BookShop {
	
	@Resource
	Map<String,User> usersMap; 
	
	@Autowired
	private  BookService bookServ;
	
	
	@RequestMapping(value = "infos",method = RequestMethod.GET)
	public String showInfos(Model model) {
		List<Book> books= bookServ.ShowSomeBooks();
		model.addAttribute("bookList", books);
		List<Book> popbooks= bookServ.ShowPopularBooks();
		model.addAttribute("popularList", popbooks);
		return "/home";
	}
	
	@RequestMapping(value = "desc",method = RequestMethod.GET)
	public String showOneInfo(String bid, Model model) {
		Book one= bookServ.ShowOneByID(bid);
		bookServ.updOnePopular(one);
		model.addAttribute("book", one);
		return "/books/desc";
	}
	
	
	
	@RequestMapping(value = "log",method = RequestMethod.GET)
	public String showLog(String msg, Model model) {
		model.addAttribute("message", "Web demo with SSM framework");
		return "/userlog";
	}
	
	
	@RequestMapping(value = "log",method = RequestMethod.POST)	
	public String checkUser(
			@Validated UserValid user,BindingResult br,
			HttpSession se,Model model) {
		
		System.out.println(user.getUsername()+"========="+user.getPassword());
		//客户端提交数据格式通过服务器端验证后
		if(!br.hasErrors()) {
			User  u=  usersMap.get(user.getUsername());
			if(u != null && u.getPwd().equals(user.getPassword())) {
				//用户名及密码与服务器端数据一致时
//				model.addAttribute("message", u.getNickname());							
				se.setAttribute("onlineUser", u);
				se.setMaxInactiveInterval(120);
				return 	"redirect:http://localhost:8080/WebDemo0912/infos";
			}else {
				//用户名及密码与服务器端数据不一致时	
				model.addAttribute("user",user);
				model.addAttribute("msg","Username Or Password Error");
				return 	"/userlog";
			}
				
		}else {
			//服务器端数据格式验证
			//客户端提交数据不符合格式要求时
			//返回相关登录页面（将正确格式提示信息同时传回）
			List<FieldError> fieldErrors=   br.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				System.out.println(fieldError.getField()+"====="+fieldError.getDefaultMessage());
				model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
			}
			model.addAttribute("user",user);
			return 	"/userlog";
		}		
	}
}
