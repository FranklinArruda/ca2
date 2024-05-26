package com.CA2.User.Services;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;

import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import java.util.List;

public interface HospitalDataService {
   
    
    //reference the User user class and object to when passing data to data base from getter and setter in hospital saved in repository?
   // that will be used to be called in the implemenntation, and since i am passing object in here I must be able to use it
    HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters, User user);
    
    /* 
    	how it was before passing the user ID:
    	@Override
    	HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters);
    }*/
   
    // Fetchs data once user is logged in
    List<HospitalData> findAll();
    
    
    HospitalData findById(Long id);
    
    
    void deleteById(Long id);
}
