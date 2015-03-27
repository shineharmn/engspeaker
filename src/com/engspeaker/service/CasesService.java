package com.engspeaker.service;

import java.util.List;

import com.engspeaker.dao.ICasesDao;

/**
 * 
 * @author shine
 *
 */
public class CasesService {

	private ICasesDao casesDao;
	
	public CasesService(ICasesDao casesDao){
		this.casesDao = casesDao;
	}
	
	
	public void addCase(List<String>options,String question,String answer){
		casesDao.addCase(options, question, answer); 
		
	}
}
