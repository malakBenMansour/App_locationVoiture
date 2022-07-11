package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgenceRepository extends JpaRepository<Agence,Integer> {

   @Query("SELECT agenceRepo FROM Agence agenceRepo WHERE agenceRepo.id = ?1 ")
    List<Agence> findByIdSociete(int idSociete);
}
