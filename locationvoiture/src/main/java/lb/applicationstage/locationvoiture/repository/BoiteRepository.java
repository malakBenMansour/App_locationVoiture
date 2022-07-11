package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Boite;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoiteRepository extends JpaRepository<Boite,Integer> {
    @Query("SELECT s FROM Boite s WHERE s.nom like %:keyword% ")
    List<Boite> findbynom(@Param("keyword")String keyword);
}
