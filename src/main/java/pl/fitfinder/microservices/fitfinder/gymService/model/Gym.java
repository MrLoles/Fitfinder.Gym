package pl.fitfinder.microservices.fitfinder.gymService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Gym {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @Size(min = 3, message = "Gym name should have at least 3 characters!")
    private String gymName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private List<String> openingHours;

    private String imgUrl;

    @OneToMany
    @JoinColumn(name = "gym_id")
    @JsonIgnore
    private List<GymGear> gymEquipmentList;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "gym_administrators",
            joinColumns = @JoinColumn(name = "gym_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> administrators;

    @JsonIgnore
    @OneToOne
    private Contact contact;

    @JsonIgnore
    @OneToOne
    private Training training;
}