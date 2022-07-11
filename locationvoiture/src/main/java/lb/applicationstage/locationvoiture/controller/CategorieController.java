package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.Categorie;
import lb.applicationstage.locationvoiture.entities.Marque;
import lb.applicationstage.locationvoiture.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorie")
@CrossOrigin("*")

public class CategorieController {
    @Autowired
    CategorieService categorieService;

    private String add_template="categorie/add";
    private String list_template="categorie/list";
    private String list_redirect="redirect:/categorie/all";
    private String edit_template="redirect:/categorie/modif";

/*
                    POSTMAN controller
    **************************************

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
    */

    /*
       ************************ CRUD + TEMPLATE

     */
    @GetMapping("/all")
    public String afficher(Model model,String keyword)
    {

        if(keyword!=null)
        {
            model.addAttribute("categories", categorieService.findbyName(keyword));
        }
        else {

            List<Categorie> categories = categorieService.afficher();
            model.addAttribute("categories", categories);
        }
        return list_template;
    }
    @GetMapping("/add")
    public String add(Categorie categorie, Model model){
        model.addAttribute("categorie", categorie);
        return add_template;
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("categorie") Categorie categorie, BindingResult result, Model model){
        model.addAttribute("categorie", categorie);

        if(result.hasErrors()){
            return add_template;
        }
        categorieService.add(categorie);

        return list_redirect;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model)
    {
        categorieService.delete(id);
        return list_redirect;
    }
    /*
    Partie Update
     */
    @GetMapping("/find/{id}")
    public String findById(@PathVariable int id,Model model)
    {
        Categorie categorie=categorieService.findById(id);
        model.addAttribute("categorie", categorie);
        return edit_template;
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Categorie categorie = categorieService.findById(id);

        model.addAttribute("categorie", categorie);

        return "categorie/modif";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("categorie") Categorie categorie ,BindingResult result, Model model){


         if(result.hasErrors()){return edit_template;
        }
        categorieService.update(categorie);

        return list_redirect;
    }

}
