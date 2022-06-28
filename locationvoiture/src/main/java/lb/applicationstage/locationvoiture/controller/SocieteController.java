package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/societe")
@CrossOrigin("*")
public class SocieteController {

        @Autowired
        SocieteService societeService;
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




}

