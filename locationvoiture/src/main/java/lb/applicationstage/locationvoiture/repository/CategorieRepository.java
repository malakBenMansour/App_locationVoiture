package lb.applicationstage.locationvoiture.repository;

import lb.applicationstage.locationvoiture.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
