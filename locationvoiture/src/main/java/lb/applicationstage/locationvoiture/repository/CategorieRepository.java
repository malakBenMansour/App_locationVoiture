package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Categorie;
import lb.applicationstage.locationvoiture.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
    @Query("SELECT s FROM Categorie s WHERE s.nom like %:keyword% ")
    List<Categorie> findbynom(@Param("keyword")String keyword);
}
