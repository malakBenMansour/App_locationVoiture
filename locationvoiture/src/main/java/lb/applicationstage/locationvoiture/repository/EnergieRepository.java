package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Energie;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnergieRepository extends JpaRepository<Energie,Integer> {
    @Query("SELECT s FROM Energie s WHERE s.nom like %:keyword% ")
    List<Energie> findbynom(@Param("keyword")String keyword);
}
