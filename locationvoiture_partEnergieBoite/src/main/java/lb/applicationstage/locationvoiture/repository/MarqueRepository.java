package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque,Integer> {
}
