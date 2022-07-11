package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeleRepository extends JpaRepository<Modele,Integer> {
}
