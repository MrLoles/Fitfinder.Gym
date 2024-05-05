package pl.fitfinder.microservices.fitfinder.gymService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.fitfinder.microservices.fitfinder.gymService.model.Address;
import pl.fitfinder.microservices.fitfinder.gymService.model.Contact;
import pl.fitfinder.microservices.fitfinder.gymService.model.GymGear;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GymWithEquipment {
    private String gymName;
    private Address address;
    private List<String> openingHours;
    private List<GymGear> gymEquipmentList;
    private Contact contact;
}
