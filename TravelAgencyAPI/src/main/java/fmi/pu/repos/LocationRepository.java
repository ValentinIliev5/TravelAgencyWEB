package fmi.pu.repos;

import fmi.pu.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location,Integer> {
    Optional<Location> findByStreet(String name);
}
