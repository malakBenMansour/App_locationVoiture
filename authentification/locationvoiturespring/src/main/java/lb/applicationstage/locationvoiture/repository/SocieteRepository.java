package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SocieteRepository extends JpaRepository<Societe, Integer> {

    @Query("SELECT s FROM Societe s WHERE s.nom like %:keyword% ")
    List<Societe> findbynom(@Param("keyword")String keyword);
}
