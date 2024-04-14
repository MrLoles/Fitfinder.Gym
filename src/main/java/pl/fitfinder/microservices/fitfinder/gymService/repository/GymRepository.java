package pl.fitfinder.microservices.fitfinder.gymService.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;

import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Integer> {
    Optional<Gym> findByGymName(String gymName);
    Page<Gym> findByGymNameContainingIgnoreCase(String gymName, Pageable pageable);
    Page<Gym> findByAddress_CityContainingIgnoreCase(String city, Pageable pageable);
    Page<Gym> findByAddress_CityAndGymNameContainingIgnoreCase(String city, String gymName, Pageable pageable);
}
