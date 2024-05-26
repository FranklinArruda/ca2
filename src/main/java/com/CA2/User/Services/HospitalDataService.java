package com.CA2.User.Services;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import java.util.List;

public interface HospitalDataService {
   
    /**
     * Saves hospital data provided by the user along with the associated user information.
     * 
     * @param hospitalDataGettersAndSetters The getters and setters containing hospital data.
     * @param user The user associated with the hospital data.
     * @return The saved HospitalData object.
     */
    public HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters, User user);
    
    /* 
        Before passing the user ID:
        @Override
        HospitalData save(HospitalDataGettersAndSetters hospitalDataGettersAndSetters);
    */
   
    
    /**
     * Fetches all hospital data associated with the currently logged-in user.
     * 
     * @return A list of HospitalData objects.
     */
    public List<HospitalData> findAll();
    
    
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
