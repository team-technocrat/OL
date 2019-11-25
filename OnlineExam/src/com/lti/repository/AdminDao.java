package com.lti.repository;

import com.lti.model.Admin;

public interface AdminDao {
	public Admin findByEmail(String email);
}
