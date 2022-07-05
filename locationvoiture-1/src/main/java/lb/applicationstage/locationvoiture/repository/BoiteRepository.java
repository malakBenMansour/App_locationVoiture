package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Boite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoiteRepository extends JpaRepository<Boite,Integer> {
}
