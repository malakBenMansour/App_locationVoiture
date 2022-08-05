package lb.applicationstage.locationvoiture.repository;

import java.util.Optional;

import lb.applicationstage.locationvoiture.entities.ERole;
import lb.applicationstage.locationvoiture.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}