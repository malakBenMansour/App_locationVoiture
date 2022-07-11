package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Modele;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele,Integer> {
    @Query("SELECT s FROM Modele s WHERE s.nom like %:keyword% ")
    List<Modele> findbynom(@Param("keyword")String keyword);
}
