

package com.CA2.User.Controller;
import java.security.Principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




import com.CA2.User.Entity.User;
import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Services.HospitalDataService; // import hospital data service to use in the CONTROLLER
import com.CA2.User.Services.UserService;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import com.CA2.GettersAndSetters.UserGettersAndSetters;

@Controller
public class UserController {
	
@Autowired
private HospitalDataService hospitalDataService;

 @Autowired
 private UserDetailsService userDetailsService;

 private UserService userService;

 public UserController(UserService userService) {
  this.userService = userService;
 }
 
 
/**
 * It sets the DEFAULT page on loading the application by using the '(/)' mapping.
 * Map the root URL ("/") to the register/login page
 * @return html home page
 */
 
 @GetMapping("/")
 public String defaultPage(Model model) {
     return "home"; 
 }
 
 

 
 
 @GetMapping("/registerGet")
 public String register(Model model, UserGettersAndSetters userGettersAndSetters) {
	 model.addAttribute("user", userGettersAndSetters);
	 return "register";
 }
 

 
 @PostMapping("/registerPost")
 public String registerSava(@ModelAttribute("user") UserGettersAndSetters userGettersAndSetters, Model model) {
     User user = userService.findByUsername(userGettersAndSetters.getUsername());
    
     if (user != null) {
         model.addAttribute("Userexist", user);
         return "register";
     }
     
     userService.save(userGettersAndSetters);
     return "redirect:/registerGet?success=true"; // Append success parameter
 }

 
 
 

 @GetMapping("/login")
 public String login(Model model, UserGettersAndSetters userGettersAdnSetters) {
	 model.addAttribute("user", userGettersAdnSetters);
  	return "login";
 }
  
 
 
 
 
 
 
 
 
 @GetMapping("/dashboard")
 public String home(Model model, Principal principal) {
     if (principal == null) {
         return "redirect:/login";
     }

     UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
     model.addAttribute("userdetail", userDetails);

     
     
     // Fetch hospital data from the database
     List<HospitalData> hospitalDataList = hospitalDataService.findAll();
     model.addAttribute("hospitalDataList", hospitalDataList);

     return "dashboard";
 }
 
}