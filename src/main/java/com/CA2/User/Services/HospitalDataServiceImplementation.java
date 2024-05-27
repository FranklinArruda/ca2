package com.CA2.User.Services;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;
import com.CA2.User.Repositories.HospitalDataRepository;
import com.CA2.User.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

// import the importsfor pagination
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;

//import list
import java.util.List;

@Service
public class HospitalDataServiceImplementation implements HospitalDataService {

    @Autowired
    private HospitalDataRepository hospitalDataRepository;

    public HospitalDataServiceImplementation(HospitalDataRepository hospitalDataRepository) {
    	  super();
    	  this.hospitalDataRepository = hospitalDataRepository;
    	 }
    
    /*
    @Override
    public List<HospitalData> findAll() {
    	
        return hospitalDataRepository.findAll();
    }*/
    
    // WITH PAGINATION
    @Override
    public List<HospitalData> findAll(int offset) {
    	
    	/*
       
        PAGINATION SORT FROM BIGGEST TO SMALLEST dataset because when I add a new data I can see where it goes right away.
        
        (I could add the SEARCH functionality to it)
        
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(offset / 20, 20, sort); // PageRequest needs page number, not offset
        
        *
        */
    	
    	// Without SORTING but startting from smalllest to biggest
         Pageable pageable = PageRequest.of(offset / 20, 20);
        
        return hospitalDataRepository.findAll(pageable).getContent();
    }

    

    @Override
    public HospitalData findById(Long id) {
        return hospitalDataRepository.findById(id).orElse(null);
    }
/*
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
    }*/
    
  
    
    
    //	how it was before passing the user ID:
    	
    	
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
