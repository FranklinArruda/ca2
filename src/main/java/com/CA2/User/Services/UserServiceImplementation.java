
package com.CA2.User.Services;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CA2.User.Entity.User;
import com.CA2.GettersAndSetters.UserGettersAndSetters;
import com.CA2.User.Repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

 @Autowired
 PasswordEncoder passwordEncoder;

 private UserRepository userRepository;

 public UserServiceImplementation(UserRepository userRepository) {
  super();
  this.userRepository = userRepository;
 }

 @Override
 public User findByUsername(String username) {
  return userRepository.findByUsername(username);
 }

 @Override
 public User save(UserGettersAndSetters userGettersAndSetters) {
  User createNewUser = new User(userGettersAndSetters.getUsername(), passwordEncoder.encode(userGettersAndSetters.getPassword()),
		  userGettersAndSetters.getFullname());
  return userRepository.save(createNewUser);
 }

}*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CA2.User.Entity.User;
import com.CA2.GettersAndSetters.UserGettersAndSetters;
import com.CA2.User.Repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

 @Autowired
 PasswordEncoder passwordEncoder;

 private UserRepository userRepository;

 public UserServiceImplementation(UserRepository userRepository) {
  super();
  this.userRepository = userRepository;
 }

 @Override
 public User findByUsername(String username) {
  return userRepository.findByUsername(username);
 }

 @Override
 public User save(UserGettersAndSetters userGettersAndSetters) {
  User user = new User(userGettersAndSetters.getUsername(), passwordEncoder.encode(userGettersAndSetters.getPassword()),
		  userGettersAndSetters.getFullname());
  return userRepository.save(user);
 }

}