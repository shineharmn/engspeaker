package com.engspeaker.dao.impl;

import org.hibernate.Session;

import com.engspeaker.dao.IUserDao;
import com.engspeaker.entity.User;
import com.engspeaker.utils.HibernateSessionFactory;

public class UserDaoImpl implements IUserDao{

	private Session session = HibernateSessionFactory.getSession();
	
	@Override
	public User findUser(String username, String password) {
		
		return null;
	}

	@Override
	public void addUser(String username, String password, String nickname) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setLastUnlock(0); 
		
	}

	@Override
	public void updateUserInfo(String username,String password,int lastUnclock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserPortrait() {
		// TODO Auto-generated method stub
		
	}

}
