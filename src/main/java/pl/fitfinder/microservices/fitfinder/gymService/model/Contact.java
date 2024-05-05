package pl.fitfinder.microservices.fitfinder.gymService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;
    private String email;
    private String phoneNo;
    private String instagramLink;
    private String facebookLink;
    @OneToOne
    @JsonIgnore
    private Gym gym;
}
