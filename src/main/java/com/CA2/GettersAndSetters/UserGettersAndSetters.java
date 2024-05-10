package com.CA2.GettersAndSetters;

public class UserGettersAndSetters {

	 private String username;
	 private String password;
	 private String fullname;

	 public UserGettersAndSetters(String username, String password, String fullname) {
	  super();
	  this.username = username;
	  this.password = password;
	  this.fullname = fullname;
	 }

	 public String getUsername() {
	  return username;
	 }

	 public void setUsername(String username) {
	  this.username = username;
	 }

	 public String getPassword() {
	  return password;
	 }

	 public void setPassword(String password) {
	  this.password = password;
	 }

	 public String getFullname() {
	  return fullname;
	 }

	 public void setFullname(String fullname) {
	  this.fullname = fullname;
	 }

	 @Override
	 public String toString() {
	  return "UserGettersAndSetters [username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
	 }
}
/*
public class UserGettersAndSetters {

 private String username;
 private String password;
 private String fullname;

 public UserGettersAndSetters(String username, String password, String fullname) {
  super();
  this.username = username;
  this.password = password;
  this.fullname = fullname;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getFullname() {
  return fullname;
 }

 public void setFullname(String fullname) {
  this.fullname = fullname;
 }

 @Override
 public String toString() {
  return "UserDto [username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
 }
}*/