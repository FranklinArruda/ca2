package com.CA2.User.Services;

import com.CA2.User.Entity.HospitalData;

import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import java.util.List;

public interface HospitalDataService {
    List<HospitalData> findAll();
    
    HospitalData findById(Long id);
    
    HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters);
    
    
    void deleteById(Long id);
}
