package com.engspeaker.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.engspeaker.dao.IUserDao;
import com.engspeaker.dao.impl.UserDaoImpl;
import com.engspeaker.entity.User;
import com.engspeaker.service.UserService;

/**
 * 
 * @author shine
 *
 */
@Controller
@RequestMapping("/user.do")
public class UserController {

	private IUserDao userDao = new UserDaoImpl();
	
	private UserService userService = new UserService(userDao);
	
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=login")
	String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		User user = userService.login(username,password);
		
		if(user!=null){
			JSONObject json = JSONObject.fromObject(user);
			out.print(json.toString());
		}else{
			out.print("");
		}
		
		return null;
	}
	
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=register")
	String register(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String registerInfo = request.getParameter("userInfo");
		User user = userService.addUser(registerInfo);
		if(user!=null){
			JSONObject json = JSONObject.fromObject(user);
			out.print(json.toString());
		}else{
			out.print("");
		}
		
		return null;
	}
	
	
	/**
	 * 用户数据更新，user表用户自己的一列所有数据一起更，不包括头像路径
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=update")
	String update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String updateInfo = request.getParameter("updateInfo");
		
		userService.updateUserInfo(updateInfo);
		
		return null;
	}
	
	/**
	 * 更新头像
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=portrait")
	String portrait(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		userService.updatePortrait(request);
		
		return null;
	}
	
}
