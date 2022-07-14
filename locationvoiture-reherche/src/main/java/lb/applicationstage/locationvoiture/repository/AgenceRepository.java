package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Agence;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgenceRepository extends JpaRepository<Agence,Integer> {

   @Query("SELECT agenceRepo FROM Agence agenceRepo WHERE agenceRepo.id = ?1 ")
    List<Agence> findByIdSociete(int idSociete);

    @Query("SELECT s FROM Agence s WHERE s.nom like %:keyword% ")
    List<Agence> findbynom(@Param("keyword")String keyword);
}
