package com.lijialu.mapper;

import java.util.List;

import com.lijialu.pojo.User;

public interface UserMapper {
	public List<User> findAllUsers();
	/*
	public int ajaxCheckLogin(String loginname);
	public void add(User user);
	public User findByLoginnameAndLoginpass(String loginname,String loginpass);
	public int findByUidAndPassword(String uid,String password);
	public void updatePassword(String password,String uid);
	*/
}
