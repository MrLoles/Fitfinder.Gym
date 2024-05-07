package pl.fitfinder.microservices.fitfinder.gymService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.fitfinder.microservices.fitfinder.gymService.dto.ContactDTO;
import pl.fitfinder.microservices.fitfinder.gymService.dto.EquipmentGymGearDTO;
import pl.fitfinder.microservices.fitfinder.gymService.dto.GymWithEquipment;
import pl.fitfinder.microservices.fitfinder.gymService.exception.exceptions.GymNotFound;
import pl.fitfinder.microservices.fitfinder.gymService.exception.exceptions.UserNotFound;
import pl.fitfinder.microservices.fitfinder.gymService.model.*;
import pl.fitfinder.microservices.fitfinder.gymService.repository.*;
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

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Gym addGym(Gym gym) {
        gym.setGymEquipmentList(new ArrayList<>());
        gym.getAddress().setGym(gym);
        gym.setContact(new Contact());
        gym.getContact().setGym(gym);
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

    public GymWithEquipment getGymInformations(int id) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));

        return new GymWithEquipment(gym.getGymName(), gym.getAddress(), gym.getOpeningHours(), gym.getGymEquipmentList(), gym.getContact(), gym.getTraining());
    }

    public void deleteEquipment(int id, int equipmentId) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        gym.getGymEquipmentList().removeIf(equipment -> equipment.getId() == equipmentId);
        gymRepository.save(gym);
    }

    public Contact setGymContact(int id, ContactDTO contactData){
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        Contact contact;
        if(gym.getContact() != null){
            contact = gym.getContact();
        } else{
            contact = new Contact();
            contact.setGym(gym);
            contactRepository.save(contact);
        }
        contact.setEmail(contactData.getEmail());
        contact.setPhoneNo(contactData.getPhoneNo());
        contact.setInstagramLink(contactData.getInstagramLink());
        contact.setFacebookLink(contactData.getFacebookLink());
        gym.setContact(contact);
        gymRepository.save(gym);
        return contact;
    }

    public List<String> setGymWorkingHours(int id, List<String> workingHours){
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        gym.setOpeningHours(workingHours);
        gymRepository.save(gym);

        return workingHours;
    }

    public Training setGymTraining(int id, Training trainingData) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));
        Training training;

        if(gym.getTraining() != null){
            training = gym.getTraining();
        } else{
            training = new Training();
            training.setGym(gym);
        }

        if (training.getExercises() != null) {
            training.getExercises().clear();
        }

        List<Exercise> currentExercises = training.getExercises();
        if (currentExercises != null) {
            currentExercises.clear();
        } else {
            currentExercises = new ArrayList<>();
            training.setExercises(currentExercises);
        }

        List<Exercise> newExercises = trainingData.getExercises();
        if (newExercises != null) {
            for (Exercise exercise : newExercises) {
                exercise.setTraining(training);
                currentExercises.add(exercise);
            }
        }

        training.setName(trainingData.getName());

        trainingRepository.save(training);
        gym.setTraining(training);
        gymRepository.save(gym);

        return training;
    }

    public Training getGymTraining(int id) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymNotFound("Gym not found with id: " + id));

        return gym.getTraining();
    }
}

