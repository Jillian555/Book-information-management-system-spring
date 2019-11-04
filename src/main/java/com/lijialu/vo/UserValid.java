package com.lijialu.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserValid {
	
	@NotBlank(message="{user.username.empty}")
	@Size(max=6,min=3,message="{user.username.size}")
	private String username;
	@Size(max=6,min=3,message="{user.password.size}")
	private String password;
	
	public UserValid() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	
}
