package com.lti.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.Admin;
import com.lti.model.Language;
import com.lti.services.LanguageService;

@Controller
@RequestMapping(value="/admin/searchquestion")
public class SearchQuestionController {
	@Autowired
	private LanguageService languageService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showSearchQuestion(Map model,HttpSession session){
		   if((session.getAttribute("adminEmail"))==null){
			   Admin admin=new Admin();
			   model.put("admin",admin);
			   return "/admin/adminlogin";
			 }
		   Language language=new Language();
		   model.put("language", language);
		   model.put("languagelist", languageService.listLanguages());
		   return "/admin/searchquestion";
	 }
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processSearchQuestion(@Validated Language language,Map model){
		   Long languageId=language.getLanguageId();
		   if(languageId==-1){
			  model.put("languagelist", languageService.listLanguages());
			  model.put("errormessage", "Select Language");
			  return new ModelAndView("admin/searchquestion");
		   }
		   return new ModelAndView("redirect:questionlist.html?languageId="+language.getLanguageId());
	 }
 }
