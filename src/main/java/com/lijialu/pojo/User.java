package com.lijialu.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String uid;
	private String nickname;
	private String pwd;
		
	public User() {	}

	public User(String uid, String nickname, String pwd) {
		super();
		this.uid = uid;
		this.nickname = nickname;
		this.pwd = pwd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", nickname=" + nickname + ", pwd=" + pwd + "]";
	}
	
	
	
	
}
