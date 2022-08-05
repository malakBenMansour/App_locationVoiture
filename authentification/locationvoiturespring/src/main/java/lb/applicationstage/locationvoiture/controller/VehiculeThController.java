package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.service.BoiteService;
import lb.applicationstage.locationvoiture.service.ModeleService;
import lb.applicationstage.locationvoiture.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@Controller
@RequestMapping("/vehicules")
@CrossOrigin("*")
public class VehiculeThController {
    @Autowired
    VehiculeService vehiculeService;
    @Autowired
    ModeleService modeleService;
    @Autowired
    BoiteService boiteService;


    private String add_template = "vehicule/add";
    private String list_template = "vehicule/list";
    private String list_redirect = "redirect:/vehicules/all";
    private String edit_template = "redirect:/vehicules/edit";


    @GetMapping("/tout")
    @ResponseBody
    public List<Vehicule> afficher()
    {
        return vehiculeService.afficher();
    }
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
       /* List<Modele> modeles = modeleService.afficher();
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
        return "vehicule/list";*/
        return findPaginated(1, "nom", "asc", model,keyword);

    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model,String keyword) {
        int pageSize = 5;

        Page<Vehicule> page = vehiculeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Vehicule> listEmployees = page.getContent();
        List<Modele> modeles = modeleService.afficher();
        model.addAttribute("modeles", modeles);


        List<Boite> boites = boiteService.afficher();
        model.addAttribute("boites", boites);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        if(keyword!=null)
        {
            model.addAttribute("vehicule", vehiculeService.findbyName(keyword));
        }
        else {
            //List<Marque> marques = $marqueService.afficher();
            model.addAttribute("vehicule", listEmployees);
        }

        return list_template;
    }










    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("vehicule") Vehicule vehicule, BindingResult result, Model model) {


        //if(result.hasErrors()){return edit_template;
        //}
        vehiculeService.update(vehicule);

        return list_redirect;
    }



}
