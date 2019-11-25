package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
    EntityManager em;
	
	@Transactional
	@Override
	public Admin findByEmail(String email) 
	{
		String q="select a from Admin a where a.email=?1";
		TypedQuery<Admin> query=em.createQuery(q,Admin.class);
		query.setParameter(1, email);
		Admin a=query.getSingleResult();
		return a;	
	}

}
