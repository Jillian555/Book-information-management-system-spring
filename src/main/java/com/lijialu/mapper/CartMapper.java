package com.lijialu.mapper;

import java.util.List;

import com.lijialu.pojo.CartItem;

public interface CartMapper {
	
	public List<CartItem> findByUid(String uid);
	public CartItem findByUidAndBid(CartItem item);
	public void addCartItem(CartItem item);
	public void updateQuantity(CartItem item);
	public void deleteOne(String cartItemid);
	public void deleteCart(String uid);
	/*
	public List<CartItem> findByUser(String uid);
	
	public CartItem findByCartItemId(String cartItemId);
	
	public void batchDelete(List<String> list);
	public List<CartItem> loadCartItems(List<String> list);
	*/
}
