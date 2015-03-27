package com.engspeaker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.engspeaker.dao.ICasesDao;
import com.engspeaker.dao.IUserDao;
import com.engspeaker.dao.impl.CasesDaoImpl;
import com.engspeaker.dao.impl.UserDaoImpl;
import com.engspeaker.service.CasesService;
import com.engspeaker.service.UserService;


/**
 * 
 * @author shine
 *
 */
@Controller("/cases.do")
public class CasesController {
	
	private ICasesDao casesDao = new CasesDaoImpl();
	
	private CasesService userService = new CasesService(casesDao);	
	
	/**
	 * 增加关卡
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=add")
	String addcases(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		List<String> options = new ArrayList<String>();
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");		
		
		for(int i = 1;i<=9;i++){
			options.add(request.getParameter("option"+i));
		}
		
		userService.addCase(options, question, answer); 
		
		return null;
	}
}
