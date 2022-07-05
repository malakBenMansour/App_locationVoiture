package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Modele;
import lb.applicationstage.locationvoiture.service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@RestController
@RequestMapping("/modele")
@CrossOrigin("*")
public class ModeleController {

    @Autowired
    ModeleService modeleService;

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

}
