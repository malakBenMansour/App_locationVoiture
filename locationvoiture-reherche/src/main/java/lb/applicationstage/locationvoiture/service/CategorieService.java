package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Categorie;
import lb.applicationstage.locationvoiture.entities.Energie;
import lb.applicationstage.locationvoiture.entities.Modele;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.repository.CategorieRepository;
import lb.applicationstage.locationvoiture.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class CategorieService {
private final CategorieRepository $categorierepo;

@Autowired
    public CategorieService(CategorieRepository $categorierepo) {
        this.$categorierepo = $categorierepo;
    }
    @Autowired
    ModeleRepository modeleRepository;

    public Categorie add(Categorie c)
    {
        return $categorierepo.save(c);
    }
    public List<Categorie> afficher()
    {
        return (List<Categorie>) $categorierepo.findAll();
    }
    public Categorie update(Categorie c)
    {
        Categorie categorie = $categorierepo.findById(c.getId()).get();
        categorie.setNom(c.getNom());
        $categorierepo.save(categorie);
        return categorie;
    }
    public Categorie findById(int id)
    {
        return $categorierepo.findById(id).orElse(null);
    }
    public void delete(int id)
    {
        $categorierepo.deleteById(id);
    }

    public void assignModeletoCategorie(int idModele, int idCategorie) {
        Modele a = modeleRepository.findById(idModele).orElse(null);
        Categorie s = $categorierepo.findById(idCategorie).orElse(null);
        s.setListModele(null);
        $categorierepo.save(s);
    }

    public List<Categorie> findbyName(String nom)
    {
        return (List<Categorie>) $categorierepo.findbynom(nom);
    }
}
