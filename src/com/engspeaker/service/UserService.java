package com.engspeaker.service;

import net.sf.json.JSONObject;

import com.engspeaker.dao.IUserDao;
import com.engspeaker.entity.User;

/**
 * 
 * @author shine
 *
 */
public class UserService {

	
	private IUserDao userDao;
	
	public UserService(IUserDao userDao){
		this.userDao = userDao;
	}
	
	/**
	 * 用户修改密码，关卡有更新时调用
	 * @param username
	 * @param password
	 */
	public void updateUserInfo(String json){
		
		JSONObject jsonObject = JSONObject.fromObject(json);
		String username = jsonObject.getString("username");		
		String password = jsonObject.getString("password");	
		int lastUnclock = Integer.valueOf(jsonObject.getString("lastUnclock"));	
		
		userDao.updateUserInfo(username, password, lastUnclock);
	}
	
	/**
	 * 注册时添加到服务器
	 * @param username
	 * @param password
	 * @param nickname
	 */
	public void addUser(String json){
		
		JSONObject jsonObject = JSONObject.fromObject(json);
		String username = jsonObject.getString("username");		
		String password = jsonObject.getString("password");	
		String nickname = jsonObject.getString("nickname");	
		
		userDao.addUser(username, password, nickname);
		
	}
	
	
	/**
	 * 登录确认，正确则返回user对象
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password){
		
		
		
		return userDao.findUser(username, password);
	}
	
	/**
	 * 更新头像信息
	 */
	public void updatePortrait(){
		
		
	}
}
