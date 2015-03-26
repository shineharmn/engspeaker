package com.engspeaker.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.engspeaker.entity.User;

@Controller
@RequestMapping("/home.do")
public class HomeController {

//	private IUserDao userDao = new UserDaoImpl();
//	
//	private UserService userService = new UserService(userDao);
	
	@RequestMapping(params="method=index")
	String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		PrintWriter out = response.getWriter();
		out.print(username+password);
		return null;
	}
	

}
