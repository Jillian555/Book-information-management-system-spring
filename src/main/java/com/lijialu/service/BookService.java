package com.lijialu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijialu.mapper.BookMapper;
import com.lijialu.pojo.Book;

@Service
public class BookService {
	
	@Autowired
	private  BookMapper bookInfos;
	
	public List<Book> ShowSomeBooks(){
		List<Book> list=new ArrayList<Book>();
		list=bookInfos.findSome();
		return  list;
	}

	public List<Book> ShowPopularBooks(){
		List<Book> list=new ArrayList<Book>();
		list=bookInfos.findSomeByOrder();
		return  list;
	}
	
	public Book ShowOneByID(String bid){
		Book rtn =bookInfos.findByBid(bid);
		return  rtn;
	}
	
	public void updOnePopular(Book book){
		int i= book.getOrderBy();
		book.setOrderBy(i+1);
		bookInfos.editPopular(book);		
	}
	
}
