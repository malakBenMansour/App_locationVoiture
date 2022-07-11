package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {
}
