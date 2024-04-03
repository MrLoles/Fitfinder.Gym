package pl.fitfinder.microservices.fitfinder.gymService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;

import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Integer> {
    Optional<Gym> findByGymName(String gymName);
}
