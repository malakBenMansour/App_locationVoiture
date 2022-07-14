package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.service.BoiteService;
import lb.applicationstage.locationvoiture.service.ModeleService;
import lb.applicationstage.locationvoiture.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@Controller
@RequestMapping("/vehicule")
@CrossOrigin("*")
public class VehiculeController {
    @Autowired
    VehiculeService vehiculeService;
    @Autowired
    ModeleService modeleService;
    @Autowired
    BoiteService boiteService;


    private String add_template = "vehicule/add";
    private String list_template = "vehicule/list";
    private String list_redirect = "redirect:/vehicule/all";
    private String edit_template = "redirect:/vehicule/edit";


    @GetMapping("/tout")
    @ResponseBody
    public List<Vehicule> afficher()
    {
       return vehiculeService.afficher();
    }

    @PostMapping("/add/{idModele}/{idBoite}")
    @ResponseBody
    public Vehicule add(@RequestBody Vehicule vehicule,@PathVariable int idModele, @PathVariable int idBoite)
    {
        return vehiculeService.add(vehicule,idModele,idBoite);
    }
   /*
    @GetMapping("/find/{id}")
    @ResponseBody
    public Vehicule findById(@PathVariable int id)
    {
        return vehiculeService.findById(id);
    }
    @PostMapping("/add/{idModele}")
    @ResponseBody
    public Vehicule add(@RequestBody Vehicule v,@PathVariable int idModele)
    {
        return vehiculeService.add(v,idModele);
    }
    @PutMapping("/update")
    @ResponseBody
    public Vehicule update(@RequestBody Vehicule v)
    {
        return vehiculeService.update(v);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id)
    {
        vehiculeService.delete(id);
    }

*/

 /*

       CRUD + TEMPLATE
     */

    @GetMapping("/add")
    public String add(Vehicule vehicule, Model model) {
        model.addAttribute("vehicule", vehicule);
        List<Modele> modele = modeleService.afficher();
        model.addAttribute("modele", modele);
        List<Boite> boite = boiteService.afficher();
        model.addAttribute("boite", boite);

        return add_template;
    }


    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Vehicule vehicule= vehiculeService.findById(id);
        model.addAttribute("vehicule", vehicule);

        List<Modele> modele = modeleService.afficher();
        model.addAttribute("modele", modele);
        List<Boite> boite = boiteService.afficher();
        model.addAttribute("boite", boite);

        return "vehicule/edit";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("vehicule") Vehicule vehicule, BindingResult result, Model model) {
        model.addAttribute("vehicule", vehicule);
        List<Modele> modele = modeleService.afficher();
        model.addAttribute("modele", modele);
        List<Boite> boite = boiteService.afficher();
        model.addAttribute("boite", boite);

        vehiculeService.ajout(vehicule);
       return list_redirect;
       //return all(model);
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        vehiculeService.delete(id);

        return list_redirect;
    }

    @GetMapping("/all")
    public String all(Model model,String keyword) {
        List<Modele> modeles = modeleService.afficher();
        model.addAttribute("modeles", modeles);


        List<Boite> boites = boiteService.afficher();
        model.addAttribute("boites", boites);


        if(keyword!=null)
        {
            model.addAttribute("vehicule", vehiculeService.findbyName(keyword));
        }
        else {

            List<Vehicule> vehicule = vehiculeService.afficher();

            model.addAttribute("vehicule", vehicule);
        }
        return "vehicule/list";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("vehicule") Vehicule vehicule, BindingResult result, Model model) {


        //if(result.hasErrors()){return edit_template;
        //}
        vehiculeService.update(vehicule);

        return list_redirect;
    }



}
