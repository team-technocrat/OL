package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.User;
import com.lti.repository.UserDao;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
   
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> listUsers() {
		return userDao.listUsers();		
	}
	
	@Override
	public void saveUser(User user){
	 	 userDao.saveUser(user);
	  }
	
	@Override
	public List<User> getUserByUserEmail(String userEmail){
		   return userDao.getUserByUserEmail(userEmail);
	  }
	
	@Override
	public List<User> validateLoginUser(String userEmail,String password){
		   return userDao.validateLoginUser(userEmail, password);
		
		
	}
}
