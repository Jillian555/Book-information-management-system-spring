package com.lijialu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lijialu.pojo.Book;
import com.lijialu.pojo.CartItem;
import com.lijialu.pojo.User;
import com.lijialu.service.CartService;

@Controller
public class Cart {

	@Autowired
	private CartService cartServ;

	// �鿴���û��Ĺ��ﳵ
	@RequestMapping(value = "/showCartInfos")
	public String showCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user = (User) req.getSession().getAttribute("onlineUser");
		String uid = user.getUid();
		req.setAttribute("ownerId", uid);
		List<CartItem> cartItemList = cartServ.myCart(uid);
		req.setAttribute("cartItemList", cartItemList);
		return "/cart/list";
	}

	// �����Ŀ
	@RequestMapping(value = "/addCart")
	public String add(int quantity, String bid, HttpServletRequest req,
			HttpServletResponse resp,Model model) throws Exception {
		System.out.println("����addCart���ȷ���........");
		
		Book book = new Book();
		book.setBid(bid);
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setBid(bid);
		User user = (User) req.getSession().getAttribute("onlineUser");
		cartItem.setUid(user.getUid());
		cartItem.setBook(book);
		cartItem.setUser(user);
		cartServ.add(cartItem);
//		model.addAttribute("message", user.getUid()+":"+bid);
		return "redirect:http://localhost:8080/WebDemo0912/showCartInfos";
		
	}
	
	@RequestMapping(value = "/removeCart")
	public String remove( String cartItemId) throws Exception {
		cartServ.delete(cartItemId);
		return "redirect:http://localhost:8080/WebDemo0912/showCartInfos";
	}
	
	@RequestMapping(value = "/cleanCart")
	public String clean( String uid) throws Exception {
		cartServ.clean(uid);
		return "redirect:http://localhost:8080/WebDemo0912/showCartInfos";
	}
	
}
