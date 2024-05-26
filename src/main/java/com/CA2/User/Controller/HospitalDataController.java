package com.CA2.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Entity.User;
import com.CA2.User.Services.HospitalDataService;
import com.CA2.User.Services.UserService;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import com.CA2.GettersAndSetters.UserGettersAndSetters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import jakarta.validation.Valid;

@Controller
public class HospitalDataController { 
    
    @Autowired
   private HospitalDataService hospitalDataService;
    
    @Autowired
    private UserService userService;
    
    // Declare logger
    private static final Logger logger = LoggerFactory.getLogger(HospitalDataController.class);

    
    @GetMapping("/addData")
    public String showAddHospitalDataForm(Model model, HospitalDataGettersAndSetters hospitalDataGettersAndSetters) {
   	 model.addAttribute("hospitalData", hospitalDataGettersAndSetters);
        return "addHospitalData";
    }

    /*
     * In order for the jakarta validation to work properly I must have imported in here, reference the @Valid annotation 
     * in the hospital data method parameter, as well as importing the BindingResult result 
     * 
     * */
    @PostMapping("/addData")
    public String addHospitalData(@Valid @ModelAttribute("hospitalData") HospitalDataGettersAndSetters hospitalDataGettersAndSetters, BindingResult result, Model model) {
        
    	// this part here will be used to append the values valid from my Hospital Getters and setters class. It will return
    	// its page with the values appened using the 
    	if (result.hasErrors()) {
            // If there are validation errors, return to the form
            return "addHospitalData";
        }

        try {
            // Retrieve the currently authenticated user
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User user = userService.findByUsername(username);

            // Save the hospital data to the database with the associated user
            hospitalDataService.save(hospitalDataGettersAndSetters, user);

            // Redirect with a success parameter
            return "redirect:/addData?success";

        } catch (Exception e) {
            // Log the exception (optional)
            logger.error("Error saving hospital data", e);
            // Redirect with a failure parameter
            return "redirect:/addData?failure";
        }
    }
    /*
     * 
     
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
*/
    
    
    
    @GetMapping("/hospitaldata/delete/{id}")
    public String deleteHospitalData(@PathVariable("id") Long id, Model model) {
        hospitalDataService.deleteById(id);
        return "redirect:/dashboard";
    }

    
}
