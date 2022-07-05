package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Energie;
import lb.applicationstage.locationvoiture.service.EnergieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energie")
@CrossOrigin("*")
public class EnergieController {
@Autowired
    EnergieService $energieService;
@GetMapping("/all")
@ResponseBody
public List<Energie> afficher()
{
    return (List<Energie>) $energieService.afficher();
}

@GetMapping("/find/{id}")
@ResponseBody
public Energie findById(@PathVariable int id)
{
    return (Energie) $energieService.findById(id);
}

@PostMapping("/add")
@ResponseBody
public Energie add(@RequestBody Energie e)
{
    return (Energie) $energieService.add(e);
}
@DeleteMapping("/delete/{id}")
@ResponseBody
public void delete(@PathVariable int id)
{
    $energieService.delete(id);
}

@PutMapping("/update")
@ResponseBody
public Energie update(@RequestBody Energie e)
{
   return  $energieService.update(e);
}












}
