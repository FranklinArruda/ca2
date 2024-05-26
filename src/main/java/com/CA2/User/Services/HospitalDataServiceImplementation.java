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

    @Override
    public HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters, User user) {
        HospitalData hospitalData = new HospitalData(
            hospitalDataGettersAndSetters.getYear(),
            hospitalDataGettersAndSetters.getCounty(),
            hospitalDataGettersAndSetters.getHospital(),
            hospitalDataGettersAndSetters.getSurgery(),
            hospitalDataGettersAndSetters.getCases()
        );
        hospitalData.setUser(user); // Set the user
        return hospitalDataRepository.save(hospitalData);
    }
    
   /* 
    * 
    	how it was before passing the user ID:
    	
    	
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
    }*/


    @Override
    public void deleteById(Long id) {
        hospitalDataRepository.deleteById(id);
    }
    
    
    
    
    
    @Override
    public HospitalData updateHospitalData(Long id, HospitalDataGettersAndSetters newData) {
        // Find the hospital data entry by its ID
        HospitalData existingData = hospitalDataRepository.findById(id).orElse(null);
        
        // If the entry exists, update its fields
        if (existingData != null) {
            // Update the fields with new data from the HospitalDataGettersAndSetters object
            existingData.setYear(newData.getYear());
            existingData.setCounty(newData.getCounty());
            existingData.setHospital(newData.getHospital());
            existingData.setSurgery(newData.getSurgery());
            existingData.setCases(newData.getCases());
            
            // Save the updated entry back to the database
            return hospitalDataRepository.save(existingData);
        } else {
            // Entry with the given ID not found
            return null;
        }
}
    }
