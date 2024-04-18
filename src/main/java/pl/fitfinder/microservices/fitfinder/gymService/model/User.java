package pl.fitfinder.microservices.fitfinder.gymService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;

    @JsonIgnore
    @ManyToMany(mappedBy = "administrators")
    private List<Gym> administratedGyms;
}