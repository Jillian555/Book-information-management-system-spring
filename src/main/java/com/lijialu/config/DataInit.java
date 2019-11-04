package com.lijialu.config;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lijialu.mapper.UserMapper;
import com.lijialu.pojo.User;

@Configuration
public class DataInit {
	
	@Autowired
	UserMapper usersInfos;
	
	@Bean(name="usersMap")
	public Map<String,User> getUsersMap() {
		
		System.out.println("User数据初始化化开始.......");
		Map<String,User> rtn =new HashMap<String,User>();
		List<User> users= usersInfos.findAllUsers();
		for (User u : users) {
			rtn.put(u.getUid(), u);
		}		
		System.out.println("User数据初始化化结束.......");		
        return rtn;
    }
	
}
