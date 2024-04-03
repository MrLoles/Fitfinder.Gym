package pl.fitfinder.microservices.fitfinder.gymService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;
import pl.fitfinder.microservices.fitfinder.gymService.repository.GymRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;


    public Gym addGym(Gym gym) {
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
}

