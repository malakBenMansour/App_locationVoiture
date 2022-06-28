package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.Marque;
import lb.applicationstage.locationvoiture.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping ("/marque")
@CrossOrigin("*")
public class MarqueController {
    @Autowired
    MarqueService $marqueService;

    @GetMapping("/all")
    @ResponseBody
    public List<Marque> afficher()
    {
      return   $marqueService.afficher();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Marque findById(@PathVariable int id)
    {
        return $marqueService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id)
    {
        $marqueService.delete(id);
    }
    @PostMapping("/add")
    @ResponseBody
    public Marque add(@RequestBody Marque m)
    {
        return $marqueService.add(m);
    }

    @PutMapping("/update")
    @ResponseBody
    public Marque update(@RequestBody Marque m)
    {
        return $marqueService.update(m);
    }
}
