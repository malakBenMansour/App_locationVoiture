package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.DTO.CountColor;
import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.service.BoiteService;
import lb.applicationstage.locationvoiture.service.ModeleService;
import lb.applicationstage.locationvoiture.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/all")
    @ResponseBody
    public List<Vehicule> afficher()
    {
       return vehiculeService.afficher();
    }

    @PostMapping("/add")
    @ResponseBody
    public Vehicule add(@RequestBody Vehicule vehicule)
    {
        return vehiculeService.ajout(vehicule);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Vehicule findById(@PathVariable int id)
    {
        return vehiculeService.findById(id);
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicule> updateEmployee(@PathVariable int id, @RequestBody Vehicule employeeDetails) {
        Vehicule employee = vehiculeService.findById(id);
        employee.setNom(employeeDetails.getNom());
        employee.setBoite(employeeDetails.getBoite());
        employee.setModele(employeeDetails.getModele());
        employee.setDateDebService(employeeDetails.getDateDebService());
        employee.setNumChassis(employeeDetails.getNumChassis());
        employee.setMatricule(employeeDetails.getMatricule());
        employee.setColor(employeeDetails.getColor());


        Vehicule updateBoite = vehiculeService.update(employee);
        return ResponseEntity.ok(updateBoite);


    }
    @GetMapping("/stat")
    @ResponseBody
    List<CountColor> statistique(){
        return vehiculeService.statistique();
    }



}
