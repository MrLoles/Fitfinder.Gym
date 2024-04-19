package pl.fitfinder.microservices.fitfinder.gymService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @OneToOne
    @JoinColumn(name = "gym_id")
    @JsonIgnore
    private Gym gym;
}