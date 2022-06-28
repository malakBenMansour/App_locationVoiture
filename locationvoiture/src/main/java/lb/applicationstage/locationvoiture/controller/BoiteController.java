package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.service.BoiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boite")
@CrossOrigin("*")
public class BoiteController {
@Autowired
    BoiteService $boiteservice;



@GetMapping("/all")
public String afficher(Model model)
{
    List<Boite> boiteList=$boiteservice.afficher();
    model.addAttribute("boiteList",boiteList);

    return "boite/boitelist";
}

@GetMapping("/find/{id}")
@ResponseBody
public Boite findById(@PathVariable int id)
{
    return $boiteservice.findById(id);
}
    @PostMapping("/add")
    @ResponseBody
    public Boite add(@RequestBody Boite b)
    { return $boiteservice.add(b); }
/* CRUD AVEC POSTMAN
@PutMapping("/update")

public Boite update(@RequestBody Boite b)
{
    return $boiteservice.update(b);
}

*/
@GetMapping("/delete/{id}")
public String delete(@PathVariable int id)
{
    $boiteservice.delete(id);
    return "boite/boitelist";
}
/* Rectification CRUD template */

    
}
