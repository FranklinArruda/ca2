package com.CA2.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;
import com.CA2.User.Services.HospitalDataService;
import com.CA2.User.Services.UserService;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import com.CA2.GettersAndSetters.UserGettersAndSetters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HospitalDataController { 
    
    @Autowired
   private HospitalDataService hospitalDataService;
    
 // Declare logger
    private static final Logger logger = LoggerFactory.getLogger(HospitalDataController.class);

    
    @GetMapping("/addData")
    public String showAddHospitalDataForm(Model model, HospitalDataGettersAndSetters hospitalDataGettersAndSetters) {
   	 model.addAttribute("hospitalData", hospitalDataGettersAndSetters);
        return "addHospitalData";
    }

    @PostMapping("/addData")
    public String addHospitalData(@ModelAttribute("hospitalData") HospitalDataGettersAndSetters hospitalDataGettersAndSetters,Model model) {
    	
    	try {
    		
    		
    		
    		
    	
    	// Save the hospital data to the database
        hospitalDataService.save(hospitalDataGettersAndSetters);

        // Redirect with a success parameter
        return "redirect:/addData?success";
   


   } catch (Exception e) {
       // Log the exception (optional)
       logger.error("Error saving hospital data", e);
       // Redirect with a failure parameter
       return "redirect:/addData?failure";
   }


    }

}
