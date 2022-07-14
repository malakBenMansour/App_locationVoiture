package lb.applicationstage.locationvoiture.service;


import lb.applicationstage.locationvoiture.entities.*;
import lb.applicationstage.locationvoiture.repository.CategorieRepository;
import lb.applicationstage.locationvoiture.repository.EnergieRepository;
import lb.applicationstage.locationvoiture.repository.MarqueRepository;
import lb.applicationstage.locationvoiture.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleService {

    @Autowired
    ModeleRepository modeleRepository;
    @Autowired
    EnergieRepository energieRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    MarqueRepository marqueRepository;

    public List<Modele> afficher()
    {
        return (List<Modele>) modeleRepository.findAll();
    }

    public Modele update(Modele m)
    {
        Modele modele=modeleRepository.findById(m.getId()).get();
        modele.setNom(m.getNom());
        modele.setCategorie(m.getCategorie());
        modele.setEnergie(m.getEnergie());
        modele.setMarque(m.getMarque());
        modele.setNbplaces(m.getNbplaces());
        modele.setNbportes(m.getNbportes());
        modele.setPuissance(m.getPuissance());
        modele.setVersion(m.getVersion());
        modele.setVolumecoffre(m.getVolumecoffre());

        modeleRepository.save(modele);
        return modele;
    }
    public  Modele findById(int id)
    {
        return modeleRepository.findById(id).orElse(null);
    }

    public Modele add(Modele m,int idCategorie,int idMarque,int idEnergie)
    {
        Marque marque=marqueRepository.findById(idMarque).orElse(null);
        Categorie c=categorieRepository.findById(idCategorie).orElse(null);
        Energie e =energieRepository.findById(idEnergie).orElse(null);

        m.setMarque(marque);
        m.setEnergie(e);
        m.setCategorie(c);

        modeleRepository.save(m);
        return  m;

    }

public void delete(int id)
{
    modeleRepository.deleteById(id);
}
    public void ajout(Modele a)
    {
        modeleRepository.save(a);
        //return a;
    }

    public List<Modele> findbyName(String nom)
    {
        return (List<Modele>) modeleRepository.findbynom(nom);
    }




}
