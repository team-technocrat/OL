package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Language;
import com.lti.repository.LanguageDao;

@Service("languageService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageDao languageDao;
	
	public List<Language> listLanguages(){		   
		   return languageDao.listLanguages();	 
	 }

	@Override
	public List getLanguageByLanguageId(Long languageId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
