package lb.applicationstage.locationvoiture.service;

import lb.applicationstage.locationvoiture.entities.Modele;
import lb.applicationstage.locationvoiture.entities.Vehicule;
import lb.applicationstage.locationvoiture.repository.ModeleRepository;
import lb.applicationstage.locationvoiture.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VehiculeService {
    @Autowired
    VehiculeRepository vehiculeRepository;
    @Autowired
    ModeleRepository modeleRepository;

public List<Vehicule> afficher()
{
    return (List<Vehicule>) vehiculeRepository.findAll();
}
public Vehicule update(Vehicule v)
{
    Vehicule vehicule=vehiculeRepository.findById(v.getId()).get();
    vehicule.setColor(v.getColor());
    vehicule.setDateDebService((Date) v.getDateDebService());
    vehicule.setNom(v.getNom());
    vehicule.setMatricule(v.getMatricule());
    vehicule.setNumChassis(v.getNumChassis());
    vehiculeRepository.save(vehicule);
    return vehicule;
}

public Vehicule findById(int id)
{
    return vehiculeRepository.findById(id).orElse(null);
}
public Vehicule add(Vehicule v, int idModele)
{
    Modele m=modeleRepository.findById(idModele).orElse(null);
    v.setModele(m);
    v.setDateDebService(new Date());
    vehiculeRepository.save(v);
    return v;
}
public void delete(int id)
{
    vehiculeRepository.deleteById(id);
}
}
