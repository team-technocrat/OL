package com.lti.validators;


public class UserForm{
	
	Long userId;
	String userName;
	String userEmail;
	String password;
	String confirmPassword;
	String userGender;
	String phoneNo;
	String address;
	
	public void setUserId(Long userId){
		   this.userId=userId;
	 }	
	public Long getUserId(){
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
	
	public void setPassword(String password){
		   this.password=password;
	 }
	public String getPassword(){
		  return password;
	}
	
	public void setConfirmPassword(String confirmPassword){
		   this.confirmPassword=confirmPassword;
	 }
	public String getConfirmPassword(){
		  return confirmPassword;
	}
	
	public void setUserGender(String userGender){
		   this.userGender=userGender;
	 }
	public String getUserGender(){
		  return userGender;
	}
	
	public void setPhoneNo(String phoneNo){
		   this.phoneNo=phoneNo;
	 }
	public String getPhoneNo(){
		  return phoneNo;
	}
	
	public void setAddress(String address){
		   this.address=address;
	 }
	public String getAddress(){
		  return address;
	}
	
}
