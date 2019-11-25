package com.lti.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.Admin;
import com.lti.services.AdminService;
import com.lti.validators.AdminLoginValidator;

@Controller
@RequestMapping("/admin/adminlogin")
public class AdminLoginController {
	@Autowired
	private AdminLoginValidator adminLoginValidator;
	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAdminLogin(Map model, HttpSession session) {
		if (session.getAttribute("adminEmail") == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return new ModelAndView("/admin/adminlogin");
		} else {
			return new ModelAndView("redirect:addquestion.html");
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processAdminLogin(@Validated Admin admin,
			BindingResult result, Map model, HttpSession session) {
		adminLoginValidator.validate(admin, result);
		if (result.hasErrors()) {
			return new ModelAndView("/admin/adminlogin");
		}
		
		
		
		
			Admin admin1 = new Admin();
			Admin a=adminService.login(admin1);
			session.setAttribute("adminName", admin1.getAdminName());
		
		session.setAttribute("adminEmail", admin.getAdminEmail());
		return new ModelAndView("redirect:addquestion.html");
	}
}
