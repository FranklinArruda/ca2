package com.CA2.User.Controller;

//import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Services.HospitalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/hospitaldata")
public class HospitalDataController {

    @Autowired
    private HospitalDataService hospitalDataService;

   /* @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("hospitalDataList", hospitalDataService.findAll());
        return "home";
    }

    @GetMapping("/edit/{id}")
    public String editHospitalData(@PathVariable Long id, Model model) {
        HospitalData hospitalData = hospitalDataService.findById(id);
        if (hospitalData == null) {
            return "redirect:/hospitaldata/home";
        }
        model.addAttribute("hospitalData", hospitalData);
        return "editHospitalData";
    }

    @PostMapping("/edit")
    public String updateHospitalData(@ModelAttribute HospitalData hospitalData) {
        hospitalDataService.save(hospitalData);
        return "redirect:/hospitaldata/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteHospitalData(@PathVariable Long id) {
        hospitalDataService.deleteById(id);
        return "redirect:/hospitaldata/home";
    }*/
    
   
    
    /*
    
    @GetMapping("/add")
    public String showAddHospitalDataForm(Model model) {
        return "addHospitalData";  // Ensure this matches the template name exactly
    }
    
    *
    *
    */
    
    
    
    
    
    /*
    @PostMapping("/add")
    public String addHospitalData(@ModelAttribute HospitalData hospitalData) {
        hospitalDataService.save(hospitalData);
        return "redirect:/hospitaldata/home";
    }*/
    

    
    
    
    
    
    /*
     * 
     * 
     * 
     * 
    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome"; // Assuming "welcome" is the name of your welcome HTML page
    }
    
    */
}
