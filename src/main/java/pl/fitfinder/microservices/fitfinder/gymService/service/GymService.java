package pl.fitfinder.microservices.fitfinder.gymService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fitfinder.microservices.fitfinder.gymService.dto.EquipmentGymGearDTO;
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
                .orElseThrow(() -> new RuntimeException("Gym not found with id: " + id));
    }

    public String getOpeningHoursOfGym(String name) {
        Optional<Gym> gym = gymRepository.findByGymName(name);

        return gym.map(Gym::getOpeningHours)
                .orElseThrow(() -> new RuntimeException("Gym not found with name: " + name));
    }

    public GymGear addGymGear(String name, EquipmentGymGearDTO equipmentName){
        Optional<Gym> gym = gymRepository.findByGymName(name);
        GymEquipment gymEquipment = GymEquipment.valueOf(equipmentName.getGymName());
        Gym updatedGym = gym.orElseThrow(() -> new RuntimeException("Gym not found with name: " + name));

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
}

