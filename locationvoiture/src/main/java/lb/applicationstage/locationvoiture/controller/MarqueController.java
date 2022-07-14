package lb.applicationstage.locationvoiture.controller;

import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.entities.Marque;
import lb.applicationstage.locationvoiture.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@Controller
@RequestMapping ("/marque")
@CrossOrigin("*")
public class MarqueController {
    @Autowired
    MarqueService $marqueService;
    private String add_template="marque/add";
    private String list_template="marque/list";
    private String list_redirect="redirect:/marque/all";
    private String edit_template="redirect:/marque/edit";






/*
             CRUD TEST POSTMAN => @RESTController
***************************************
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

 */
    /*
    CRUD avec integration template
     */

    @GetMapping("/all")
    public String afficher(Model model,String keyword)
    {
      /*  if(keyword!=null)
        {
            model.addAttribute("marques", $marqueService.findbyName(keyword));
        }
        else {
            List<Marque> marques = $marqueService.afficher();
            model.addAttribute("marques", marques);
        }
        return list_template;
        */
        return findPaginated(1, "nom", "asc", model,keyword);
    }
    @GetMapping("/add")
    public String add(Marque marque, Model model){
        model.addAttribute("marque", marque);
        return add_template;
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("marque") Marque marque, BindingResult result, Model model){
        model.addAttribute("marque", marque);

        if(result.hasErrors()){
            return add_template;
        }
        $marqueService.add(marque);

        return list_redirect;
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,Model model)
    {
        $marqueService.delete(id);
        return list_redirect;
    }

    /*
    Partie Update
     */
    @GetMapping("/find/{id}")
    public String findById(@PathVariable int id,Model model)
    {
        Marque marque=$marqueService.findById(id);
        model.addAttribute("marque", marque);
        return edit_template;
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Marque marque = $marqueService.findById(id);

        model.addAttribute("marque", marque);

        return "marque/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("marque") Marque marque ,BindingResult result, Model model){


       // if(result.hasErrors()){
          //  return edit_template;
        //}
        $marqueService.update(marque);
        //update(boite);
        return list_redirect;
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model,String keyword) {
        int pageSize = 5;

        Page<Marque> page = $marqueService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Marque> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        if(keyword!=null)
        {
            model.addAttribute("marques", $marqueService.findbyName(keyword));
        }
        else {
            //List<Marque> marques = $marqueService.afficher();
            model.addAttribute("marques", listEmployees);
        }

        return list_template;
    }

}

