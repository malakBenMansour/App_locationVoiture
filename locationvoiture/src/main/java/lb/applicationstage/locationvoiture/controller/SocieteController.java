package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Categorie;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/societe")
@CrossOrigin("*")
public class SocieteController {

    @Autowired
    SocieteService societeService;

    private String add_template = "societe/add";
    private String list_template = "societe/list";
    private String list_redirect = "redirect:/societe/all";
    private String edit_template = "redirect:/societe/edit";
    private String list_recherche = "redirect:/societe/recherche";

        /*

        ********************************** CRUD POSTMAN ****************

        @GetMapping("/all")
        @ResponseBody
        public List<Societe> getAll()
        {
            return societeService.afficher();
        }

        @GetMapping("/find/{id}")
        @ResponseBody
        public Societe find(@PathVariable int id)
        {
         return societeService.findSocietebyID(id);
        }

        @PostMapping("/add")
        @ResponseBody
        public Societe add(@RequestBody Societe societe)
        {
            return societeService.addSociete(societe);
        }

        @DeleteMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable int id)
        {
            societeService.supprimer(id);
        }

        @PutMapping("/update")
        @ResponseBody
    public Societe update (@RequestBody Societe societe)
        {
            return societeService.modifier(societe);
        }

*/


    /*
     **************** CRUD + TEMPLATE *******************

     */

    @GetMapping("/all")
    public String afficher(Model model,String keyword) {

  if(keyword!=null)
  {
      model.addAttribute("societe", societeService.findbyName(keyword));
  }
else {


      List<Societe> societe = societeService.afficher();
      model.addAttribute("societe", societe);
  }
        return list_template;
    }

    @GetMapping("/add")
    public String add(Societe societe, Model model) {
        model.addAttribute("societe", societe);
        return add_template;
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("societe") Societe societe, BindingResult result, Model model) {
        model.addAttribute("societe", societe);

        if (result.hasErrors()) {
            return add_template;
        }
        societeService.addSociete(societe);

        return list_redirect;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        societeService.supprimer(id);
        return list_redirect;
    }

    /*
    Partie Update
     */
    @GetMapping("/find/{id}")
    public String findById(@PathVariable int id, Model model) {
        Societe societe = societeService.findSocietebyID(id);
        model.addAttribute("societe", societe);
        return edit_template;
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Societe societe = societeService.findSocietebyID(id);

        model.addAttribute("societe", societe);

        return "societe/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("societe") Societe societe, BindingResult result, Model model) {

        societeService.modifier(societe);

        return list_redirect;
    }
/*

Recerche
 */

    @GetMapping("/search")
    public String recherche(@ModelAttribute("keyword") Societe societe, Model model) {
        String keyword="";
        model.addAttribute("keyword", keyword);
       List<Societe>  societes=societeService.findbyName(keyword);
        model.addAttribute("societe", societes);

        return list_template;
    }

}