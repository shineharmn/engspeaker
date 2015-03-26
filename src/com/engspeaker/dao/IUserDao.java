package com.engspeaker.dao;

import com.engspeaker.entity.User;

public interface IUserDao {

	public void updateUserInfo(String username,String password,int lastUnclock);
	
	public User findUser(String username,String password);
	
	public void addUser(String username,String password,String nickname);
	
	public void updateUserPortrait();
}
