package com.CA2.User.Services;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;
import com.CA2.User.Repositories.HospitalDataRepository;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;

public interface HospitalDataService {
	
	
   
    /**
     * Saves hospital data provided by the user along with the associated user information.
     * 
     * @param hospitalDataGettersAndSetters The getters and setters containing hospital data.
     * @param user The user associated with the hospital data.
     * @return The saved HospitalData object.
     */
	
	//REFERECING THE USER ID
	
   // public HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters, User user);
    
     
	
	// WITHOUT REFERENCING THE USER OBJECT
       public HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters);
    
   
    
       
    /**
     * Fetches all hospital data associated with the currently logged-in user.
     * 
     * @return A list of HospitalData objects.
     */
   // public List<HospitalData> findAll();
    
       
       
       // with pagination
       public List<HospitalData> findAll(int offset);
    
    /**
     * Deletes hospital data by its unique identifier.
     * 
     * @param id The ID of the hospital data to be deleted.
     */
    void deleteById(Long id);
    
    
    /**
     * Finds hospital data by its unique identifier.
     * 
     * @param id The ID of the hospital data to be found.
     * @return The HospitalData object found, or null if not found.
     */
    public HospitalData findById(Long id);
    
    
    /**
     * Updates existing hospital data with new information.
     * 
     * @param id The ID of the hospital data to be updated.
     * @param newData The new data to update the hospital data with.
     * @return The updated HospitalData object.
     */
    public HospitalData updateHospitalData(Long id, HospitalDataGettersAndSetters newData);
}
