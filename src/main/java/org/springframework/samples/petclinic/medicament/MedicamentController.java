/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.medicament;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Isaac
 */

@Controller
class MedicamentController {
    private static final String VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM = "medicaments/createOrUpdateMedicamentForm";
    private final MedicamentRepository medicaments;

    public MedicamentController(MedicamentRepository clinicService) {
        this.medicaments = clinicService;
    }
    
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    @GetMapping("/medicament/new")
    public String initCreationForm(Map<String, Object> model) {
        Medicament medicament = new Medicament();
        model.put("medicament", medicament);
        return VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM;
    }
    
    @PostMapping("/medicament/new")
    public String processCreationForm(@Valid Medicament medicament, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM;
        } else {
            this.medicaments.save(medicament);
            return "redirect:/medicaments/" + medicament.getId();
        }
    }
    
    @GetMapping("/medicament/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("medicament", new Medicament());
        return "medicaments/createOrUpdateMedicamentForm";
    }
    
    @GetMapping("/medicament/{medId}")
    public ModelAndView showOwner(@PathVariable("medId") int medId) {
        ModelAndView mav = new ModelAndView("medicaments/medicamentsDetails");
        mav.addObject(this.medicaments.findById(medId));
        return mav;
    }
}
