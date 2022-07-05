package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Energie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergieRepository extends JpaRepository<Energie,Integer> {
}
