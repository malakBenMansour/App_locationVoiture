package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.Categorie;
import lb.applicationstage.locationvoiture.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@CrossOrigin("*")

public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("/all")
    @ResponseBody
    public List<Categorie> afficher()
    {
        return categorieService.afficher();
    }
    @PostMapping("/add")
    @ResponseBody
    public Categorie add(@RequestBody Categorie c)
    {
       return  categorieService.add(c);

    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Categorie findByid(@PathVariable int id)
    {
        return categorieService.findById(id);

    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable int id)
    {
        categorieService.delete(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public Categorie update(@RequestBody Categorie c)
    {
        return categorieService.update(c);
    }
}
