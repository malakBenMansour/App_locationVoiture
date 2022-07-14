package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.repository.BoiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Boite> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return $boiterepository.findAll(pageable);
    }
}
