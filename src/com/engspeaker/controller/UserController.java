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

@Controller
@RequestMapping("/user.do")
public class UserController {

	private IUserDao userDao = new UserDaoImpl();
	
	private UserService userService = new UserService(userDao);
	
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
	
	@RequestMapping(params="method=register")
	String register(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		PrintWriter out = response.getWriter();
		String userInfo = request.getParameter("userInfo");
		
		userService.addUser(userInfo);
				
		return null;
	}
}
