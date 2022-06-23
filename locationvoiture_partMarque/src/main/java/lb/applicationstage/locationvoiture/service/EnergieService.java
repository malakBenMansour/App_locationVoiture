package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Energie;
import lb.applicationstage.locationvoiture.repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergieService {
    private final EnergieRepository $energieRepository;
    @Autowired
    public EnergieService(EnergieRepository $energieRepository)
    {
        this.$energieRepository=$energieRepository;
    }

    public Energie add(Energie e)
    {
        return $energieRepository.save(e);
    }
    public List<Energie> afficher()
    {
        return (List<Energie>) $energieRepository.findAll();
    }

    public Energie findById(int id)
    {
        return  $energieRepository.findById(id).orElse(null);
    }
    public void delete(int id)
    {
        $energieRepository.deleteById(id);
    }
    public Energie update(Energie e)
    {
        Energie energie=$energieRepository.findById(e.getId()).get();
        energie.setNom(e.getNom());
        $energieRepository.save(energie);
        return energie;

    }

}
