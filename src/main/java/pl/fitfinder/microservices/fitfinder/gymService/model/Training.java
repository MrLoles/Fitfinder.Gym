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
public class Training {
    @JsonIgnore
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    int dayOfWeek = 1;

    @Column(nullable = false)
    @Size(min = 3, message = "Exercise name should have at least 3 characters")
    private String name;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises;

    @JsonIgnore
    @OneToOne
    private Gym gym;

    @JsonIgnore
    private int userId = 0;
}