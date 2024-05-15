

package com.CA2.User.Repositories;

import com.CA2.GettersAndSetters.UserGettersAndSetters;
import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDataRepository extends JpaRepository<HospitalData, Long> {

	
	public HospitalData save(HospitalData hospitalData);
	
	public List<HospitalData> findAll();

}
