package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.repository.AgenceRepository;
import lb.applicationstage.locationvoiture.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lb.applicationstage.locationvoiture.entities.Societe;
import java.util.List;
@Service
public class SocieteService {
    private final SocieteRepository societerepo;

    @Autowired
    AgenceRepository agenceRepository;

    @Autowired
    public SocieteService(SocieteRepository societerepo) {
        this.societerepo = societerepo;
    }

    public Societe addSociete(Societe s) {
        return societerepo.save(s);

    }

    public List<Societe> afficher() {
        return societerepo.findAll();
    }

    public Societe modifier(Societe l) {

        Societe societe = societerepo.findById(l.getId()).get();
        societe.setNom(l.getNom());
        societe.setAdresse(l.getAdresse());
        societe.setEmail(l.getEmail());
        societe.setTel(l.getTel());
        societe.setSite(l.getSite());

        //TODO Auto-generated method stub
        societerepo.save(societe);
        return societe;
    }

    public Societe findSocietebyID(int id) {
        return societerepo.findById(id).orElse(null);
    }

    public void supprimer(int id) {
        societerepo.deleteById(id);
    }


    public void assignSocietetoAgence(int idAgence, int idSociete) {
        Agence a = agenceRepository.findById(idAgence).orElse(null);
        Societe s = societerepo.findById(idSociete).orElse(null);
        s.setListAgence(null);
        societerepo.save(s);
    }

    public List<Societe> findbyName(String nom)
    {
     return (List<Societe>) societerepo.findbynom(nom);
    }

    public Page<Societe> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return societerepo.findAll(pageable);
    }
}

