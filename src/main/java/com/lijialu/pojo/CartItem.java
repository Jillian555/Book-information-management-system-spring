package com.lijialu.pojo;

import java.math.BigDecimal;

public class CartItem {
	//���ﳵ��ϸ
	private String cartItemId;//����id
	private int quantity;//����
	private String uid;
	private String bid;
	private User user;//������û�
	private Book book;//���ﳵ��ϸ��Ӧ����Ʒ����
	
	//��ȡС������
	public double getSubtotal(){
		BigDecimal b1 = new BigDecimal(book.getCurrPrice()+"");
		BigDecimal b2 = new BigDecimal(quantity+"");
		BigDecimal b3 = b1.multiply(b2);
 		return b3.doubleValue();
	}
	
	public CartItem() {
		super();
	}


	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}
	
}
