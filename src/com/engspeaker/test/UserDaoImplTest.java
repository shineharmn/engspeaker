package com.engspeaker.test;

import org.junit.Before;
import org.junit.Test;

import com.engspeaker.dao.IUserDao;
import com.engspeaker.dao.impl.UserDaoImpl;

public class UserDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testaddUserInfo() {
		IUserDao userDao = new UserDaoImpl();
		userDao.addUser("apple", "123", "poly"); 
	}

}
