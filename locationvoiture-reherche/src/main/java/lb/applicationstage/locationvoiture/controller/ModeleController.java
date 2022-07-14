package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.service.CategorieService;
import lb.applicationstage.locationvoiture.service.EnergieService;
import lb.applicationstage.locationvoiture.service.MarqueService;
import lb.applicationstage.locationvoiture.service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/modele")
@CrossOrigin("*")
public class ModeleController {

    @Autowired
    ModeleService modeleService;

    @Autowired
    EnergieService energieService;
    @Autowired
    CategorieService categorieService;
    @Autowired
    MarqueService marqueService;

    private String add_template = "modele/add";
    private String list_template = "modele/list";
    private String list_redirect = "redirect:/modele/all";
    private String edit_template = "redirect:/modele/edit";

 /*


      *************************** Postman CRUD ***************

    @GetMapping("/all")
    @ResponseBody
    public List<Modele> afficher()
    {
        return modeleService.afficher();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Modele findById(@PathVariable int id)
    {
      return  modeleService.findById(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public Modele update(@RequestBody Modele modele)
    {
      return  modeleService.update(modele);
    }

    @PostMapping("/add/{idCategorie}/{idMarque}/{idEnergie}")
    @ResponseBody
    public Modele add(@RequestBody Modele m,@PathVariable int idCategorie,@PathVariable int idMarque,@PathVariable int idEnergie)
    {
        return modeleService.add(m,idCategorie,idMarque,idEnergie);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id)
    {
        modeleService.delete(id);
    }

    */

    /*

       ***************** CRUD + TEMPLATE

     */

    @GetMapping("/add")
    public String add(Modele modele, Model model) {
        model.addAttribute("modele", modele);
        List<Energie> energie = energieService.afficher();
        model.addAttribute("energie", energie);
        List<Categorie> categorie = categorieService.afficher();
        model.addAttribute("categorie", categorie);
        List<Marque> marque = marqueService.afficher();
        model.addAttribute("marque", marque);
        return add_template;
    }


    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Modele modele = modeleService.findById(id);
        model.addAttribute("modele", modele);
        List<Energie> energie = energieService.afficher();
        model.addAttribute("energie", energie);
        List<Categorie> categorie = categorieService.afficher();
        model.addAttribute("categorie", categorie);
        List<Marque> marque = marqueService.afficher();
        model.addAttribute("marque", marque);

        return "modele/edit";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("modele") Modele modele, BindingResult result, Model model) {
        model.addAttribute("modele", modele);
        List<Energie> energie = energieService.afficher();
        model.addAttribute("energie", energie);
        List<Categorie> categorie = categorieService.afficher();
        model.addAttribute("categorie", categorie);
        List<Marque> marque = marqueService.afficher();
        model.addAttribute("marque", marque);


        if (result.hasErrors()) {
            return add_template;
        }

        modeleService.ajout(modele);
        return list_redirect;
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        modeleService.delete(id);

        return list_redirect;
    }

    @GetMapping("/all")
    public String all(Model model,String keyword) {
        List<Energie> energies = energieService.afficher();
        model.addAttribute("energies", energies);
        List<Categorie> categories = categorieService.afficher();
        model.addAttribute("categories", categories);
        List<Marque> marques = marqueService.afficher();
        model.addAttribute("marques", marques);

        if(keyword!=null)
        {
            model.addAttribute("modele", modeleService.findbyName(keyword));
        }
        else {

            List<Modele> modele = modeleService.afficher();

            model.addAttribute("modele", modele);
        }
        return "modele/list";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("modele") Modele modele, BindingResult result, Model model) {


        //if(result.hasErrors()){return edit_template;
        //}
        modeleService.update(modele);

        return list_redirect;
    }

}
