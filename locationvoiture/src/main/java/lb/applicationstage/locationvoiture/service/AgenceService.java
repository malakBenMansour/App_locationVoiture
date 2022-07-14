package lb.applicationstage.locationvoiture.service;


import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.entities.Marque;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.repository.AgenceRepository;
import lb.applicationstage.locationvoiture.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    @Autowired
    AgenceRepository $agencerepository;
    @Autowired
    SocieteRepository $societerepository;

    public List<Agence> afficher() {
        return (List<Agence>) $agencerepository.findAll();
    }

    public Agence update(Agence a) {
        Agence agence = $agencerepository.findById(a.getId()).get();
        agence.setNom(a.getNom());
        agence.setAdresse(a.getAdresse());
        agence.setEmail(a.getEmail());
        agence.setTel(a.getTel());
        agence.setSociete(a.getSociete());
        $agencerepository.save(agence);
        return agence;

    }

    public Agence findById(int id) {
        return $agencerepository.findById(id).orElse(null);
    }

    public Agence add(Agence a, int idSociete) {
        Societe s = $societerepository.findById(idSociete).orElse(null);
        a.setSociete(s);
        $agencerepository.save(a);
        return a;
    }

    public void delete(int id) {
        $agencerepository.deleteById(id);
    }

    public List<Agence> FindByIdSociete(int idSociete) {
        return (List<Agence>) $agencerepository.findByIdSociete(idSociete);
    }
    public void ajout(Agence a)
    {
        $agencerepository.save(a);
        //return a;
    }
    public List<Agence> findbyName(String nom)
    {
        return (List<Agence>) $agencerepository.findbynom(nom);
    }
    public Page<Agence> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return $agencerepository.findAll(pageable);
    }


}




