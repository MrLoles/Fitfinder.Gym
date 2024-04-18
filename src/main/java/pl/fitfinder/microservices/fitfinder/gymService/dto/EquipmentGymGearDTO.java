package pl.fitfinder.microservices.fitfinder.gymService.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentGymGearDTO {
    @Size(min = 2, message = "gymGearName name should have at least 2 character!")
    String gymGearName;
    int quantity;
    String imgUrl;
}