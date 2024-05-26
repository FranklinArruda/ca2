

package com.CA2.User.Controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.CA2.User.Entity.User;
import com.CA2.User.Services.UserService;
import com.CA2.GettersAndSetters.HospitalDataGettersAndSetters;
import com.CA2.GettersAndSetters.UserGettersAndSetters;

@Controller
public class UserController {

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
 
 
 @GetMapping("/login")
 public String login(Model model, UserGettersAndSetters userGettersAdnSetters) {
	 model.addAttribute("user", userGettersAdnSetters);
  	return "login";
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

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 @GetMapping("/dashboard")
 public String home(Model model, Principal principal) {
  
	 //-------------------------------------------------------------------
	 if (principal == null) {
	        // Handle case where user is not authenticated (e.g., redirect to login)
	        return "redirect:/login";
	    }
	 
	 //---------------------------------------------------------------------------------
	 
	 UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
  model.addAttribute("userdetail", userDetails);
  return "dashboard";
 }
 
 
 
}