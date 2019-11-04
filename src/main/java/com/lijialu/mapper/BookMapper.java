package com.lijialu.mapper;

import java.util.List;

import com.lijialu.pojo.Book;

public interface BookMapper {

	public List<Book> findSome();
	public List<Book> findSomeByOrder();
	public Book findByBid(String bid);
	public void editPopular(Book book);
	/*
	public void delete(String bid);
	public void edit(Book book);
	public int  findBookCountByCategory(String cid);
	public void add(Book book);
	public BookPid findByBid(String bid);
	public List<Book> findByCategory(String cid,int min,int max);
	public List<Book> findByBname(String bname,int min,int max);
	public List<Book> findByAuthor(String author,int min,int max);
	public List<Book> findByPress(String press,int min,int max);
	public List<Book> findByCombination(String bname,String author,String press,int min,int max);
	public List<Book> findByCategorys(String cid);
	public List<Book> findByBnames(String bname);
	public List<Book> findByAuthors(String author);
	public List<Book> findByPresss(String press);
	public List<Book> findByCombinations(String bname,String author,String press);
	*/
}
