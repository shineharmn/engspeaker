package com.engspeaker.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.engspeaker.dao.ICasesDao;
import com.engspeaker.dao.impl.CasesDaoImpl;
import com.engspeaker.service.CasesService;


/**
 * 
 * @author shine
 *
 */
@Controller
@RequestMapping("/cases.do")
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
	
	
	@RequestMapping(params="method=download")
	String download(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		File file = new File("D:\\暂存\\图片2.png");
		ServletOutputStream out = response.getOutputStream();
		BufferedImage bi;
		bi = ImageIO.read(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();   
        ImageIO.write(bi, "png", baos);   
        byte[] bytes = baos.toByteArray();   
		out.write(bytes);
		
		return null;
	}
}
