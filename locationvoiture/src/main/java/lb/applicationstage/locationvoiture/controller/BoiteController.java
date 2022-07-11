package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.service.BoiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boite")
@CrossOrigin("*")
public class BoiteController {
@Autowired
    BoiteService $boiteservice;

    private String add_edit_template="boite/add-edit";
    private String list_template="boite/boitelist";
    private String list_redirect="redirect:/boite/all";
    private String edit_template="redirect:/boite/edit";

   /* @PostMapping("/add")
    @ResponseBody
    public Boite add(@RequestBody Boite b)
    { return $boiteservice.add(b); }*/
// CRUD AVEC POSTMAN
@PutMapping("/update")

public Boite update(@RequestBody Boite b)
{
    return $boiteservice.update(b);
}
@GetMapping("/allBoite")
@ResponseBody
public List<Boite>all()
{
    return $boiteservice.afficher();
}


/* Rectification CRUD template */
@GetMapping("/all")
public String afficher(Model model,String keyword)
{  if(keyword!=null)
{
    model.addAttribute("boiteList", $boiteservice.findbyName(keyword));
}
else {

    List<Boite> boiteList = $boiteservice.afficher();
    model.addAttribute("boiteList", boiteList);
}
    return "boite/boitelist";
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
}
