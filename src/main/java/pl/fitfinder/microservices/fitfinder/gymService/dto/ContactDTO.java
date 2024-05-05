package pl.fitfinder.microservices.fitfinder.gymService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private String email;
    private String phoneNo;
    private String instagramLink;
    private String facebookLink;
}