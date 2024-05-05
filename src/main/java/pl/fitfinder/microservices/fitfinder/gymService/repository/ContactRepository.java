package pl.fitfinder.microservices.fitfinder.gymService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fitfinder.microservices.fitfinder.gymService.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
