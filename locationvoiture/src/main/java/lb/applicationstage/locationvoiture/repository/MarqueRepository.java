package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Marque;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarqueRepository extends JpaRepository<Marque,Integer> {
    @Query("SELECT s FROM Marque s WHERE s.nom like %:keyword% ")
    List<Marque> findbynom(@Param("keyword")String keyword);
}
