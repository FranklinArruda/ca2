package com.CA2.User.Services;

/*
import com.CA2.User.Entity.User;
import com.CA2.User.Services.UserService;
import com.CA2.GettersAndSetters.UserGettersAndSetters;

public interface UserService {
	 User findByUsername(String username);
	 User save(UserGettersAndSetters userGettersAndSetters);

	}*/

import com.CA2.User.Entity.User;
//import com.CA2.User.Services.UserService;
import com.CA2.GettersAndSetters.UserGettersAndSetters;

public interface UserService {
 User findByUsername(String username);

 User save(UserGettersAndSetters userGettersAndSetters);

}

