package com.lti.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.User;
import com.lti.services.UserService;
import com.lti.util.Encryption;
import com.lti.validators.UserForm;
import com.lti.validators.UserRegistrationValidator;

@Controller
@RequestMapping("/user/userregistration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	UserRegistrationValidator userRegistrationValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserLogin(Map model) {
		UserForm userForm = new UserForm();
		model.put("userForm", userForm);
		return "/user/userregistration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processUserLogin(@Validated UserForm userForm,
			BindingResult result, Map model) {
		userRegistrationValidator.validate(userForm, result);

		if (result.hasErrors()) {
			return new ModelAndView("/user/userregistration");
		} else {

			// set userForm value to user object.
			User user = new User();
			user.setUserName(userForm.getUserName());
			user.setUserEmail(userForm.getUserEmail());
			user.setPassword(Encryption.encrypt(userForm.getPassword()));
			user.setUserGender(userForm.getUserGender());
			user.setPhoneNo(userForm.getPhoneNo());
			user.setAddress(userForm.getAddress());

			userService.saveUser(user);
		}
		return new ModelAndView("redirect:userlogin.html");
	}
}
