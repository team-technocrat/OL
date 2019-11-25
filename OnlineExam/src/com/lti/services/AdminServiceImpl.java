package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;
import com.lti.repository.AdminDao;

@Service("adminService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	@Transactional
	public Admin login(Admin a) {
		Admin userToBeReturned=null;
		Admin uDB= adminDao.findByEmail(a.getAdminEmail());
		
		if(uDB==null)
		{
			
		}
		else if(uDB.getAdminEmail().equals(a.getAdminEmail())&&(uDB.getPassword().equals(a.getPassword())))
		{
			userToBeReturned = uDB;
		}
		else
		{
			
		}
		return userToBeReturned;
	}

}
