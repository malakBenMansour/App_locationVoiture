package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Societe;
import lb.applicationstage.locationvoiture.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {
    @Query("SELECT s FROM Vehicule s WHERE s.nom like %:keyword% ")
    List<Vehicule> findbynom(@Param("keyword")String keyword);
}
