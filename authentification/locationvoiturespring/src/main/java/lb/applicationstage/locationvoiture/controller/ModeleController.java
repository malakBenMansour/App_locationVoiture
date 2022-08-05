package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.service.CategorieService;
import lb.applicationstage.locationvoiture.service.EnergieService;
import lb.applicationstage.locationvoiture.service.MarqueService;
import lb.applicationstage.locationvoiture.service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  */

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


    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Modele> ajouter(@RequestBody Modele m)
    {
        return new ResponseEntity<>(modeleService.ajout(m), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id)
    {
        modeleService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Modele> updateEmployee(@PathVariable int id, @RequestBody Modele employeeDetails) {
        Modele employee = modeleService.findById(id);
        employee.setNom(employeeDetails.getNom());
        employee.setCategorie(employeeDetails.getCategorie());
        employee.setEnergie(employeeDetails.getEnergie());
        employee.setMarque(employeeDetails.getMarque());
        employee.setVolumecoffre(employeeDetails.getVolumecoffre());
        employee.setVersion(employeeDetails.getVersion());
        employee.setPuissance(employeeDetails.getPuissance());
        employee.setNbportes(employeeDetails.getNbportes());
        employee.setNbplaces(employeeDetails.getNbplaces());


        Modele updateBoite = modeleService.update(employee);
        return ResponseEntity.ok(updateBoite);


    }



}
