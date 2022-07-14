package lb.applicationstage.locationvoiture.controller;


import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.entities.Energie;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.service.AgenceService;
import lb.applicationstage.locationvoiture.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agence")
@CrossOrigin("*")
public class AgenceController {
    @Autowired
    AgenceService $agenceService;
    @Autowired
    SocieteService societeService;

    private String add_template = "agence/add";
    private String list_template = "agence/list";
    private String list_redirect = "redirect:/agence/all";
    private String edit_template = "redirect:/agence/edit";
/*
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

*/




    /*

       CRUD + TEMPLATE
     */

    @GetMapping("/add")
    public String add(Agence agence, Model model) {
        model.addAttribute("agence", agence);
        List<Societe> societe = societeService.afficher();
        model.addAttribute("societe", societe);

        return add_template;
    }


    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Agence agence = $agenceService.findById(id);
        model.addAttribute("agence", agence);

        List<Societe> societe = societeService.afficher();
        model.addAttribute("societe", societe);

        return "agence/edit";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("agence") Agence agence, BindingResult result, Model model) {
        model.addAttribute("agence", agence);
        List<Societe> societe = societeService.afficher();
        model.addAttribute("societe", societe);

        if (result.hasErrors()) {
            return add_template;
        }

        $agenceService.ajout(agence);
        return list_redirect;
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        $agenceService.delete(id);

        return list_redirect;
    }

    @GetMapping("/all")
    public String all(Model model,String keyword) {
         List<Societe> societes = societeService.afficher();

         model.addAttribute("societes",societes);
        if(keyword!=null)
        {
            model.addAttribute("agence", $agenceService.findbyName(keyword));
        }
        else {

            List<Agence> agence = $agenceService.afficher();

            model.addAttribute("agence", agence);
        }

        return "agence/list";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("agence") Agence agence, BindingResult result, Model model) {


        //if(result.hasErrors()){return edit_template;
        //}
        $agenceService.update(agence);

        return list_redirect;
    }
}