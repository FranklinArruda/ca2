package com.CA2.User.Entity;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * 	Yes, the @Entity and @Table(name = "user") annotations in a Hibernate entity class like User indicate that 
 * 	Hibernate should map this class to a database table named user.
 * 
 * */


@Entity
@Table(name = "user_table") // this line will match the table, but it doesnt find it will create one automatically;
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
    private Long userID;
	
    private String username;
    private String password;
    private String firstName;
    private String lastName;

 public User() {

 }

 public User(String firstName, String lastName, String username, String password) {
 	super();
     this.firstName = firstName;
     this.lastName = lastName;
     this.username = username;
     this.password = password;
 }


 public Long getId() {
  return userID;
 }

 public void setId(Long id) {
  this.userID = id;
 }

 public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String userName() {
	return username;
}

public void userName(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
 public String toString() {
  return "User [id=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + username + ", password=" + password+ "]";
 }


}

