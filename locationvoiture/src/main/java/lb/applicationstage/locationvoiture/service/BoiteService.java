package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.repository.BoiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoiteService {
    private final BoiteRepository $boiterepository;

    @Autowired
    public BoiteService(BoiteRepository $boiterepository)
    {
        this.$boiterepository=$boiterepository;
    }
    public Boite add(Boite b)
    {
       return $boiterepository.save(b);
    }
    public List<Boite> afficher()
    {
        return (List<Boite>) $boiterepository.findAll();
    }
    public Boite findById(int id)
    {

        return $boiterepository.findById(id).orElse(null);
    }
    public void delete(int id)
    {
        $boiterepository.deleteById(id);
    }

    public Boite update(Boite b)
    {
        Boite boite = $boiterepository.findById(b.getId()).get();
        boite.setNom(b.getNom());
        $boiterepository.save(boite);
        return boite;
    }

    public void save(Boite boite)
    {
        $boiterepository.save(boite);}

    public List<Boite> findbyName(String nom)
    {
        return (List<Boite>) $boiterepository.findbynom(nom);
    }
}
