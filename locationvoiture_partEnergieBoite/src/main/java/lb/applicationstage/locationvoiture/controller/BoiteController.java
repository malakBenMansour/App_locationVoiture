package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.service.BoiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boite")
@CrossOrigin("*")
public class BoiteController {
@Autowired
    BoiteService $boiteservice;
@GetMapping("/all")
@ResponseBody
public List<Boite> afficher()
{  return $boiteservice.afficher();
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

@PutMapping("/update")
@ResponseBody
public Boite update(@RequestBody Boite b)
{
    return $boiteservice.update(b);
}
@DeleteMapping("/delete/{id}")
@ResponseBody
public void delete(@PathVariable int id)
{
    $boiteservice.delete(id);
}

}
