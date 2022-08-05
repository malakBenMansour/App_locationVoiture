package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.repository.BoiteRepository;
import lb.applicationstage.locationvoiture.service.BoiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boite")
@CrossOrigin("*")
public class BoiteController {
@Autowired
    BoiteService $boiteservice;
@Autowired
    private final BoiteRepository $boiterepository;

    private String add_edit_template="boite/add-edit";
    private String list_template="boite/boitelist";
    private String list_redirect="redirect:/boite/all";
    private String edit_template="redirect:/boite/edit";

    public BoiteController(BoiteRepository $boiterepository) {
        this.$boiterepository = $boiterepository;
    }


    // POSTMAN

    @GetMapping("/all")
    public ResponseEntity<List<Boite>> getAllBoite () {
        List<Boite> employees = $boiteservice.afficher();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Boite> getEmployeeById (@PathVariable("id") int id) {
        Boite boite = $boiteservice.findById(id);
        return new ResponseEntity<>(boite, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Boite> addBoite(@RequestBody Boite boite) {
        Boite newBoite = $boiteservice.add(boite);
        return new ResponseEntity<>(newBoite, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boite> updateBoite(@RequestBody Boite boite) {
        Boite updateBoite = $boiteservice.update(boite);
        return new ResponseEntity<>(updateBoite, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoite(@PathVariable("id") int id) {
        $boiteservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boite> updateEmployee(@PathVariable int id, @RequestBody Boite employeeDetails) {
        Boite employee = $boiteservice.findById(id);
        employee.setNom(employeeDetails.getNom());

        Boite updateBoite = $boiteservice.update(employee);
        return ResponseEntity.ok(updateBoite);


    }

    @GetMapping("/findnom")

        public ResponseEntity<List<Boite>> getBoiteNom(String nom) {
            List<Boite> employees = $boiteservice.findbyName(nom);
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }



















/* Rectification CRUD template */


    /*@GetMapping("/all")
public String afficher(Model model,String keyword)
{

    return findPaginated(1, "nom", "asc", model,keyword);

}

    @GetMapping("/add")
    public String add(Boite boite, Model model){
        model.addAttribute("boite", boite);
        return add_edit_template;
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable int id,Model model)
    {
   Boite boite=$boiteservice.findById(id);
        model.addAttribute("boite", boite);

        //return "boite/edit";
         return add_edit_template;
    }


    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        Boite boite = $boiteservice.findById(id);

        model.addAttribute("boite", boite);

        return "boite/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("boite") Boite boite ,BindingResult result, Model model){


        if(result.hasErrors()){
            return edit_template;
        }
        $boiteservice.update(boite);
        //update(boite);
        return list_redirect;
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("boite") Boite boite, BindingResult result, Model model){
        model.addAttribute("boite", boite);

        if(result.hasErrors()){
            return add_edit_template;
        }
        $boiteservice.save(boite);

        return list_redirect;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model)
    {
        $boiteservice.delete(id);
       return list_redirect;
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model,String keyword) {
        int pageSize = 5;

        Page<Boite> page = $boiteservice.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Boite> listEmployees = page.getContent();



        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        if(keyword!=null)
        {
            model.addAttribute("boiteList", $boiteservice.findbyName(keyword));
        }
        else {
            //List<Marque> marques = $marqueService.afficher();
            model.addAttribute("boiteList", listEmployees);
        }

        return list_template;
    }
*/
}
