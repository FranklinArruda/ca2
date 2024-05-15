
package com.CA2.User.Controller;

import com.CA2.User.Entity.HospitalData;
import com.CA2.User.Services.HospitalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HospitalDataController {

    @Autowired
    private HospitalDataService hospitalDataService;

    @GetMapping("/hospital/home")
    public String home(Model model) {
        model.addAttribute("hospitalDataList", hospitalDataService.findAll());
        return "home";
    }

    @GetMapping("/hospitaldata/edit/{id}")
    public String editHospitalData(@PathVariable Long id, Model model) {
        HospitalData hospitalData = hospitalDataService.findById(id);
        if (hospitalData == null) {
            return "redirect:/home";
        }
        model.addAttribute("hospitalData", hospitalData);
        return "editHospitalData";
    }

    @PostMapping("/hospitaldata/edit")
    public String updateHospitalData(@ModelAttribute HospitalData hospitalData) {
        hospitalDataService.save(hospitalData);
        return "redirect:/home";
    }

    @GetMapping("/hospitaldata/delete/{id}")
    public String deleteHospitalData(@PathVariable Long id) {
        hospitalDataService.deleteById(id);
        return "redirect:/home";
    }
}
