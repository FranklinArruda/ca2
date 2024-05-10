package com.CA2.User.Entity;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Yes, the @Entity and @Table(name = "user") annotations in a Hibernate entity class like User indicate that 
 * Hibernate should map this class to a database table named user.
 * 
 * */
/*

@Entity
@Table(name = "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 // @Column(unique = true)
 private String username;
 private String password;
 private String fullname;

 public User() {

 }

 public User(String username, String password, String fullname) {
  super();
  this.username = username;
  this.password = password;
  this.fullname = fullname;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
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
  return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
 }

}*/


@Entity
@Table(name = "user_table") // this line will match the table, but it doesnt find it will create one automatically;
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
    private Long userID;

    @Column(name = "Username") // Map to the column name in the database
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Fullname")
    private String fullname;

 public User() {

 }

 public User(String username, String password, String fullname) {
  super();
  this.username = username;
  this.password = password;
  this.fullname = fullname;
 }

 public Long getId() {
  return userID;
 }

 public void setId(Long id) {
  this.userID = id;
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
  return "User [id=" + userID + ", username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
 }

}

