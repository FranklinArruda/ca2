package com.CA2.User.Services;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;
import com.CA2.User.Repositories.HospitalDataRepository;
import com.CA2.User.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;

import java.util.List;

@Service
public class HospitalDataServiceImplementation implements HospitalDataService {

    @Autowired
    private HospitalDataRepository hospitalDataRepository;

    public HospitalDataServiceImplementation(HospitalDataRepository hospitalDataRepository) {
    	  super();
    	  this.hospitalDataRepository = hospitalDataRepository;
    	 }
    
    
    @Override
    public List<HospitalData> findAll() {
        return hospitalDataRepository.findAll();
    }

    @Override
    public HospitalData findById(Long id) {
        return hospitalDataRepository.findById(id).orElse(null);
    }
    
    
    // saves the user in the repository.
    @Override
    public HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters) {
        HospitalData hospitalDT = new HospitalData(
                hospitalDataGettersAndSetters.getYear(),
                hospitalDataGettersAndSetters.getCounty(),
                hospitalDataGettersAndSetters.getHospital(),
                hospitalDataGettersAndSetters.getSurgery(),
                hospitalDataGettersAndSetters.getCases()
        );
        return hospitalDataRepository.save(hospitalDT);
    }

    
    

    @Override
    public void deleteById(Long id) {
        hospitalDataRepository.deleteById(id);
    }
}
