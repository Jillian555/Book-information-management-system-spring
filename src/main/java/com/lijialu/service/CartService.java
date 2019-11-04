package com.lijialu.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijialu.mapper.CartMapper;
import com.lijialu.pojo.CartItem;



@Service
public class CartService  {

	@Autowired
	private CartMapper cartItemMapper;
	
	
	public List<CartItem> myCart(String uid) {
		return cartItemMapper.findByUid(uid);
	}
	/* */
	public void add(CartItem cartItem) {
		
		CartItem item =  cartItemMapper.findByUidAndBid(cartItem);
		System.out.println("Cart Item:"+item);
		if(item == null){
			cartItem.setCartItemId(UUID.randomUUID().toString());
			cartItemMapper.addCartItem(cartItem);
			System.out.println("Add Item:"+cartItem.getCartItemId());
		}else{
			item.setQuantity(item.getQuantity()+cartItem.getQuantity());
			cartItemMapper.updateQuantity(item);
			System.out.println("Update Quantity:"+cartItem.getCartItemId()+":"+cartItem.getQuantity());
		}
		/*   */
	}
	
	public void delete(String cartItemId) {
		cartItemMapper.deleteOne(cartItemId);
	}
	
	public void clean(String uid) {
		cartItemMapper.deleteCart(uid);
	}
	
	
	/*
	public CartItem updateQuantity(int quantity, String cartItemId) {
		cartItemMapper.updateQuantity(quantity, cartItemId);
		return cartItemMapper.findByCartItemId(cartItemId);
	}
	
	public List<CartItem> loadCartItems(List<String> list) {
		return cartItemMapper.loadCartItems(list);
	}
	*/
}
