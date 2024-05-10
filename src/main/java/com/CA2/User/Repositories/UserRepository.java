package com.CA2.User.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CA2.GettersAndSetters.UserGettersAndSetters;
import com.CA2.User.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

 User findByUsername(String username);

 User save(UserGettersAndSetters userGettersAdnSetters);
}


