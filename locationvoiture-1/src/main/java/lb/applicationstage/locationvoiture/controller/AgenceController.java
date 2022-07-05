package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agence")
@CrossOrigin("*")
public class AgenceController {
@Autowired
    AgenceService $agenceService;

@GetMapping("/all")
@ResponseBody
public List<Agence>  afficher()
{
    return (List<Agence>) $agenceService.afficher();
}

@GetMapping("/find/{id}")
@ResponseBody
public Agence findById(@PathVariable int id)
{
    return $agenceService.findById(id);
}

@PostMapping("/add/{idSociete}")
@ResponseBody
public Agence add(@RequestBody Agence a,@PathVariable int idSociete)
{
    return $agenceService.add(a,idSociete);
}

@DeleteMapping("/delete/{id}")
@ResponseBody
public void delete(@PathVariable int id)
{
    $agenceService.delete(id);
}

@PutMapping("/update")
@ResponseBody()
public Agence update(@RequestBody Agence a)
{
    return $agenceService.update(a);
}

@GetMapping("/findSociete/{idSociete}")
@ResponseBody

public List<Agence> findByIdSociete(@PathVariable int idSociete)
{
    return (List<Agence>) $agenceService.FindByIdSociete(idSociete);
}



}
