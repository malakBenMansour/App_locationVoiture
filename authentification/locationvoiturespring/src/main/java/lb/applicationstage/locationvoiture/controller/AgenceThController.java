package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.service.AgenceService;
import lb.applicationstage.locationvoiture.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agences")
@CrossOrigin("*")
public class AgenceThController {
    @Autowired
    AgenceService $agenceService;
    @Autowired
    SocieteService societeService;

    private String add_template = "agence/add";
    private String list_template = "agence/list";
    private String list_redirect = "redirect:/agences/all";
    private String edit_template = "redirect:/agences/edit";

    /*

       CRUD + TEMPLATE
     */

    @GetMapping("/add")
    public String add(Agence agence, Model model) {
        model.addAttribute("agence", agence);
        List<Societe> societe = societeService.afficher();
        model.addAttribute("societe", societe);

        return add_template;
    }


    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Agence agence = $agenceService.findById(id);
        model.addAttribute("agence", agence);

        List<Societe> societe = societeService.afficher();
        model.addAttribute("societe", societe);

        return "agence/edit";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("agence") Agence agence, BindingResult result, Model model) {
        model.addAttribute("agence", agence);
        List<Societe> societe = societeService.afficher();
        model.addAttribute("societe", societe);

        if (result.hasErrors()) {
            return add_template;
        }

        $agenceService.ajout(agence);
        return list_redirect;
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        $agenceService.delete(id);

        return list_redirect;
    }

    @GetMapping("/all")
    public String all(Model model,String keyword) {
        List<Societe> societes = societeService.afficher();

         model.addAttribute("societes",societes);
       /* if(keyword!=null)
        {
            model.addAttribute("agence", $agenceService.findbyName(keyword));
        }
        else {

            List<Agence> agence = $agenceService.afficher();

            model.addAttribute("agence", agence);
        }

       // return "agence/list";*/


       return findPaginated(1, "nom", "asc", model,keyword);
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("agence") Agence agence, BindingResult result, Model model) {


        //if(result.hasErrors()){return edit_template;
        //}
        $agenceService.update(agence);

        return list_redirect;
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model,String keyword) {
        int pageSize = 5;

        Page<Agence> page = $agenceService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Agence> listEmployees = page.getContent();
        List<Societe> societes = societeService.afficher();

        model.addAttribute("societes",societes);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        if(keyword!=null)
        {
            model.addAttribute("agence", $agenceService.findbyName(keyword));
        }
        else {
            //List<Marque> marques = $marqueService.afficher();
            model.addAttribute("agence", listEmployees);
        }

        return list_template;
    }



}