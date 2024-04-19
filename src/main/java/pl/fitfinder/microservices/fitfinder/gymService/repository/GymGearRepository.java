package pl.fitfinder.microservices.fitfinder.gymService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.gymService.model.GymGear;

public interface GymGearRepository extends JpaRepository<GymGear, Integer> {
}
