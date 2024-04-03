package pl.fitfinder.microservices.fitfinder.gymService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;
import pl.fitfinder.microservices.fitfinder.gymService.service.GymService;

import java.util.List;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping("/add")
    public ResponseEntity<Gym> addGym(@RequestBody Gym gym) {
        Gym savedGym = gymService.addGym(gym);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGym);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gym>> getAllGyms() {
        List<Gym> gyms = gymService.getAllGyms();
        return ResponseEntity.ok(gyms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gym> getGymById(@PathVariable("id") int id) {
        Gym gym = gymService.getGymById(id);
        return ResponseEntity.ok(gym);
    }

    @GetMapping("/{name}/opening-hours")
    public String getOpeningHours(@PathVariable("name") String name) {
        return gymService.getOpeningHoursOfGym(name);
    }
}

