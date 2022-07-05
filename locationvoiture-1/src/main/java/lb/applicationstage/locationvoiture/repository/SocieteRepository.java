package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe, Integer> {
}
