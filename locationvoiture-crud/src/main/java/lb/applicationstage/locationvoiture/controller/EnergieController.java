package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Categorie;
import lb.applicationstage.locationvoiture.entities.Energie;
import lb.applicationstage.locationvoiture.service.EnergieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/energie")
@CrossOrigin("*")
public class EnergieController {
@Autowired
    EnergieService $energieService;

    private String add_template="energie/add";
    private String list_template="energie/list";
    private String list_redirect="redirect:/energie/all";
    private String edit_template="redirect:/energie/modif";

/*

*************** CRUD POSTMAAN **********

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

*/

    /*

     ****************** CRUD + TEMPLATE

     */


    @GetMapping("/all")
    public String afficher(Model model)
    {
        List<Energie> energie=$energieService.afficher();
        model.addAttribute("energie",energie);

        return list_template;
    }
    @GetMapping("/add")
    public String add(Energie energie, Model model){
        model.addAttribute("energie", energie);
        return add_template;
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("energie") Energie energie, BindingResult result, Model model){
        model.addAttribute("energie", energie);

        if(result.hasErrors()){
            return add_template;
        }
        $energieService.add(energie);

        return afficher(model);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model)
    {
        $energieService.delete(id);
        return list_redirect;
    }
    /*
    Partie Update
     */

    @GetMapping("/find/{id}")
    public String findById(@PathVariable int id,Model model)
    {
        Energie energie=$energieService.findById(id);
        model.addAttribute("energie", energie);
        return edit_template;
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Energie energie = $energieService.findById(id);

        model.addAttribute("energie", energie);

        return "energie/modif";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("energie") Energie energie ,BindingResult result, Model model){


        //if(result.hasErrors()){return edit_template;
        //}
        $energieService.update(energie);

        return list_redirect;
    }





}
