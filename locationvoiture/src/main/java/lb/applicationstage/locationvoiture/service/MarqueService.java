package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.entities.Marque;
import lb.applicationstage.locationvoiture.entities.Modele;
import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.repository.MarqueRepository;
import lb.applicationstage.locationvoiture.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {

private final MarqueRepository $marqueRepository;
@Autowired
    ModeleRepository modeleRepository;
@Autowired
public MarqueService(MarqueRepository $marqueRepository)
{
    this.$marqueRepository=$marqueRepository;
}

public Marque add(Marque m)
{
    return $marqueRepository.save(m);
}

public List<Marque> afficher()
{
    return (List<Marque>) $marqueRepository.findAll();
}
public Marque findById(int id)
{
    return $marqueRepository.findById(id).orElse(null);
}
public void delete(int id)
{
    $marqueRepository.deleteById(id);
}
public Marque update(Marque m)
{
    Marque marque =$marqueRepository.findById(m.getId()).get();
    marque.setNom(m.getNom());
    $marqueRepository.save(marque);
    return marque;
}

    public void assignModeletoMarque(int idModele, int idMarque) {
        Modele a = modeleRepository.findById(idModele).orElse(null);
        Marque s = $marqueRepository.findById(idMarque).orElse(null);
        s.setListModele(null);
        $marqueRepository.save(s);
    }
    public List<Marque> findbyName(String nom)
    {
        return (List<Marque>) $marqueRepository.findbynom(nom);
    }

    public Page<Marque> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return $marqueRepository.findAll(pageable);
    }
}
