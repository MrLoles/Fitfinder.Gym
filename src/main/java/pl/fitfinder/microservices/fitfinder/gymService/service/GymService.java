package pl.fitfinder.microservices.fitfinder.gymService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.fitfinder.microservices.fitfinder.gymService.dto.EquipmentGymGearDTO;
import pl.fitfinder.microservices.fitfinder.gymService.dto.GymWithEquipment;
import pl.fitfinder.microservices.fitfinder.gymService.exception.exceptions.GymNotFound;
import pl.fitfinder.microservices.fitfinder.gymService.exception.exceptions.UserNotFound;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;
import pl.fitfinder.microservices.fitfinder.gymService.model.GymGear;
import pl.fitfinder.microservices.fitfinder.gymService.model.User;
import pl.fitfinder.microservices.fitfinder.gymService.repository.GymGearRepository;
import pl.fitfinder.microservices.fitfinder.gymService.repository.GymRepository;
import pl.fitfinder.microservices.fitfinder.gymService.repository.UserRepository;
import pl.fitfinder.microservices.fitfinder.gymService.utils.enums.GymEquipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.fitfinder.microservices.fitfinder.gymService.utils.JwtTokenManager.getUserId;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private GymGearRepository gymGearRepository;

    @Autowired
    private UserRepository userRepository;


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

    public GymGear addGymGear(int gymId, EquipmentGymGearDTO equipmentName) {
        Gym gym = gymRepository.findById(gymId).orElseThrow(() -> new GymNotFound("Gym not found with id: " + gymId));
        System.out.println("TEST " + equipmentName.getGymGearName());
        GymEquipment gymEquipment = GymEquipment.valueOf(equipmentName.getGymGearName());

        System.out.println("TES2" + gymEquipment.getName() + gymEquipment.getDescription());

        GymGear gearToSave = new GymGear();
        gearToSave.setName(gymEquipment.getName());
        gearToSave.setDescription(gymEquipment.getDescription());
        gearToSave.setCategory(gymEquipment.getCategory());
        gearToSave.setQuantity(equipmentName.getQuantity());
        gearToSave.setImgUrl(equipmentName.getImgUrl());
        gymGearRepository.save(gearToSave);

        gym.getGymEquipmentList().add(gearToSave);

        gymRepository.save(gym);
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

    public List<GymGear> findEquipmentById(String id) {
        Gym gym = gymRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        return gym.getGymEquipmentList();
    }

    public String addGymAdmin(String token, int id) {
        int idUser = Integer.parseInt(getUserId(token));
        User user = userRepository.findById(idUser).orElseThrow(() -> new UserNotFound("No matching user with id:" + idUser));


        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        gym.getAdministrators().add(user);
        gymRepository.save(gym);
        return "Success";
    }

    public List<User> getGymAdmins(int id) {
        return gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id)).getAdministrators();
    }

    public GymWithEquipment getInformationWithEquipment(int id) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));

        return new GymWithEquipment(gym.getGymName(), gym.getAddress(), gym.getOpeningHours(), gym.getGymEquipmentList());
    }

    public void deleteEquipment(int id, int equipmentId) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        gym.getGymEquipmentList().removeIf(equipment -> equipment.getId() == equipmentId);
        gymRepository.save(gym);
    }
}

