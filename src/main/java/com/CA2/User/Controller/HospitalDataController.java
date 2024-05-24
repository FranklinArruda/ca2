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

	  private static final Logger logger = LoggerFactory.getLogger(HospitalDataController.class);
	  
    @Autowired
    private UserService userService;

   
    
    @Autowired
    private HospitalDataService hospitalDataService;

    @GetMapping("/addDataGet")
    public String showAddHospitalDataForm(Model model) {
        model.addAttribute("hospitalData", new HospitalData());
        return "addHospitalData";
    }
    @PostMapping("/addDataPost")
    public String addHospitalData(@ModelAttribute("hospitalData") HospitalDataGettersAndSetters hospitalDataGettersAndSetters,Model model) {
       
    	 try {
             // Get the currently authenticated user
             Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
             UserDetails userDetails = (UserDetails) authentication.getPrincipal();
             User user = userService.findByUsername(userDetails.getUsername());

             // Convert getters and setter to entity
             HospitalData hospitalData = new HospitalData();
             hospitalData.setYear(hospitalDataGettersAndSetters.getYear());
             hospitalData.setCounty(hospitalDataGettersAndSetters.getCounty());
             hospitalData.setHospital(hospitalDataGettersAndSetters.getHospital());
             hospitalData.setSurgery(hospitalDataGettersAndSetters.getSurgery());
             hospitalData.setCases(hospitalDataGettersAndSetters.getCases());

             // Set the user
             hospitalData.setUser(user);

             // Save the hospital data to the database
             hospitalDataService.save(hospitalDataGettersAndSetters);
             
             // Redirect with a success parameter
             return "redirect:/addDataGet?success";
            
            
        } catch (Exception e) {
            // Log the exception (optional)
            logger.error("Error saving hospital data", e);
            // Redirect with a failure parameter
            return "redirect:/addDataGet?failure";
        }
       
    }
}
