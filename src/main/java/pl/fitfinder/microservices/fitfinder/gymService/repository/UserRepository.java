package pl.fitfinder.microservices.fitfinder.gymService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.gymService.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
