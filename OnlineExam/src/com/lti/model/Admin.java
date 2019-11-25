package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

@Id
@GeneratedValue
Long adminId;
String adminName;
String adminEmail;
String password;

public void setAdminId(Long adminId) {
this.adminId = adminId;
}

public Long getAdminId() {
return adminId;
}

public void setAdminName(String adminName) {
this.adminName = adminName;
}

public String getAdminName() {
return adminName;
}

public void setAdminEmail(String adminEmail) {
this.adminEmail = adminEmail;
}

public String getAdminEmail() {
return adminEmail;
}

public void setPassword(String password) {
this.password = password;
}

public String getPassword() {
return password;
}

public Admin(Long adminId, String adminName, String adminEmail, String password) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
	this.adminEmail = adminEmail;
	this.password = password;
}

public Admin() {
	super();
}

@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", password="
			+ password + "]";
}

}