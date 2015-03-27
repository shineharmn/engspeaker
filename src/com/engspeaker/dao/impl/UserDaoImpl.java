package com.engspeaker.dao.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Query;
import org.hibernate.Session;

import com.engspeaker.dao.IUserDao;
import com.engspeaker.entity.User;
import com.engspeaker.utils.HibernateSessionFactory;

public class UserDaoImpl implements IUserDao{

	private Session session = HibernateSessionFactory.getSession();
	
	/**
	 * 查找用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUser(String username, String password) {
		String hql = "from User as u where u.username = ? and u.password = ?";
		session.beginTransaction(); 
		Query query = session.createQuery(hql).setParameter(0, username).setParameter(1, password); 
		session.getTransaction().commit();  
		List<User> list = query.list();
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
		
	}

	/**
	 * 添加用户
	 */
	@Override
	public User addUser(String username, String password, String nickname) {
		if(findUserByName(username)){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setLastUnlock(1); 
			user.setPortrait_path("D:\\engspeaker_portrait\\"+username+"_portrait.jpg"); 	
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return user;
		}else{
			return null;
		}
				
	}

	/**
	 * 更新用户信息，不包括头像
	 */
	@Override
	public void updateUserInfo(String username,String password,int lastUnlock) {
		
		String hql = "update User u set u.password=?,u.lastUnlock=? where u.username=?";
		session.beginTransaction();
		Query query = session.createQuery(hql).setParameter(0, password).setParameter(1, lastUnlock).setParameter(2, username); 
		query.executeUpdate(); 
		session.getTransaction().commit();
		
	}

	/**
	 * 更新用户头像
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void updateUserPortrait(HttpServletRequest request) {
		
		String uploadPath = "D:\\engspeaker_portarit\\";
		String tempPath = "d:\\engspeaker_portarit\\buffer\\";
		
		File uploadPathFile = new File(uploadPath);
		File tempPathFile = new File(tempPath);
		
		if(!uploadPathFile.exists()){
			uploadPathFile.mkdirs();
		}
		if(!tempPathFile.exists()){
			tempPathFile.mkdirs();
		}
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096); 
			factory.setRepository(tempPathFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4194304); 
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> i = items.iterator();	
			
			while(i.hasNext()){
				FileItem fi = (FileItem) i.next();
				String fileName = fi.getName();
				if(fileName != null){
					File fullFile = new File(fi.getName());
				    File savedFile = new File(uploadPath, fullFile.getName());
				    fi.write(savedFile);
				                                                                                                                                                                                                                                                                                                                                                                                                       
				}
				
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			}

		
	}
	
	
	@SuppressWarnings("unchecked")
	private boolean findUserByName(String username){
		String hql = "from User as u where u.username = ? ";
		session.beginTransaction();
		Query query = session.createQuery(hql).setParameter(0, username); 
		session.getTransaction().commit();  
		List<User> list = query.list();
		return list.isEmpty();
	}

}
