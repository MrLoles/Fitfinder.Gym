package pl.fitfinder.microservices.fitfinder.gymService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gym {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @Size(min = 3, message = "Gym name should have at least 2 characters!")
    private String gymName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    private String openingHours;

}

