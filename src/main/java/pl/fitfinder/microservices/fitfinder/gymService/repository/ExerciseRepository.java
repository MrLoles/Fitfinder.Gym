package pl.fitfinder.microservices.fitfinder.gymService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.gymService.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
