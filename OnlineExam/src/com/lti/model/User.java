package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "user")
public class User {

@Id
@GeneratedValue
Long userId;
String userName;
String userEmail;
String password;
String userGender;
String phoneNo;
String address;

public User() {
	super();
}

public User(Long userId, String userName, String userEmail, String password, String userGender, String phoneNo,
		String address) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userEmail = userEmail;
	this.password = password;
	this.userGender = userGender;
	this.phoneNo = phoneNo;
	this.address = address;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", password=" + password
			+ ", userGender=" + userGender + ", phoneNo=" + phoneNo + ", address=" + address + "]";
}

public void setUserId(Long userId) {
this.userId = userId;
}

public Long getUserId() {
return userId;
}

public void setUserEmail(String userEmail) {
this.userEmail = userEmail;
}

public String getUserEmail() {
return userEmail;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getUserName() {
return userName;
}

public void setPassword(String password) {
this.password = password;
}

public String getPassword() {
return password;
}

public void setUserGender(String userGender) {
this.userGender = userGender;
}

public String getUserGender() {
return userGender;
}

public void setPhoneNo(String phoneNo) {
this.phoneNo = phoneNo;
}

public String getPhoneNo() {
return phoneNo;
}

public void setAddress(String address) {
this.address = address;
}

public String getAddress() {
return address;
}

}