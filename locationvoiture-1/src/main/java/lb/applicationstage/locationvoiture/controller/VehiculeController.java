package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.Vehicule;
import lb.applicationstage.locationvoiture.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping("/vehicule")
@CrossOrigin("*")
public class VehiculeController {
    @Autowired
    VehiculeService vehiculeService;

    @GetMapping("/all")
    @ResponseBody
    public List<Vehicule> afficher()
    {
        return vehiculeService.afficher();
    }

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


}
