package com.engspeaker.dao;

import javax.servlet.http.HttpServletRequest;

import com.engspeaker.entity.User;

public interface IUserDao {

	public void updateUserInfo(String username,String password,int lastUnclock);
	
	public User findUser(String username,String password);
	
	public User addUser(String username,String password,String nickname);
	
	public void updateUserPortrait(HttpServletRequest request);
}
