package pl.fitfinder.microservices.fitfinder.gymService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.fitfinder.microservices.fitfinder.gymService.dto.EquipmentGymGearDTO;
import pl.fitfinder.microservices.fitfinder.gymService.exception.exceptions.GymNotFound;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;
import pl.fitfinder.microservices.fitfinder.gymService.model.GymGear;
import pl.fitfinder.microservices.fitfinder.gymService.repository.GymGearRepository;
import pl.fitfinder.microservices.fitfinder.gymService.repository.GymRepository;
import pl.fitfinder.microservices.fitfinder.gymService.utils.enums.GymEquipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private GymGearRepository gymGearRepository;


    public Gym addGym(Gym gym) {
        gym.setGymEquipmentList(new ArrayList<>());
        gym.getAddress().setGym(gym);
        return gymRepository.save(gym);
    }

    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    public Gym getGymById(int id) {
        return gymRepository.findById(id)
                .orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
    }

    public List<String> getOpeningHoursOfGym(String name) {
        Optional<Gym> gym = gymRepository.findByGymName(name);

        return gym.map(Gym::getOpeningHours)
                .orElseThrow(() -> new GymNotFound("Gym not found with name: " + name));
    }

    public GymGear addGymGear(String name, EquipmentGymGearDTO equipmentName){
        Optional<Gym> gym = gymRepository.findByGymName(name);
        GymEquipment gymEquipment = GymEquipment.valueOf(equipmentName.getGymGearName());
        Gym updatedGym = gym.orElseThrow(() -> new GymNotFound("Gym not found with name: " + name));

        GymGear gearToSave = new GymGear();
        gearToSave.setName(gymEquipment.getName());
        gearToSave.setDescription(gymEquipment.getDescription());
        gearToSave.setCategory(gymEquipment.getCategory());
        gearToSave.setQuantity(2);
        gymGearRepository.save(gearToSave);

        updatedGym.getGymEquipmentList().add(gearToSave);

        gymRepository.save(updatedGym);
        return gearToSave;
    }

    public List<Gym> findGymsByCityAndName(String city, String gymName) {
        PageRequest limit = PageRequest.of(0, 5);
        if (city == null || city.isEmpty()) {
            if (gymName == null || gymName.isEmpty()) {
                return List.of();
            } else {
                return gymRepository.findByGymNameContainingIgnoreCase(gymName, limit).getContent();
            }
        } else if (gymName == null || gymName.isEmpty()) {
            return gymRepository.findByAddress_CityContainingIgnoreCase(city, limit).getContent();
        } else {
            return gymRepository.findByAddress_CityAndGymNameContainingIgnoreCase(city, gymName, limit).getContent();
        }
    }

    public List<GymGear> findEquipmentById(String id){
        Gym gym = gymRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        return gym.getGymEquipmentList();
    }
}

