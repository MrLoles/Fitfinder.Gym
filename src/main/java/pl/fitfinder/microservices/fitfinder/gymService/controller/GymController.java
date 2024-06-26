package pl.fitfinder.microservices.fitfinder.gymService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.fitfinder.microservices.fitfinder.gymService.dto.EquipmentGymGearDTO;
import pl.fitfinder.microservices.fitfinder.gymService.dto.GymWithEquipment;
import pl.fitfinder.microservices.fitfinder.gymService.model.Gym;
import pl.fitfinder.microservices.fitfinder.gymService.model.GymGear;
import pl.fitfinder.microservices.fitfinder.gymService.model.User;
import pl.fitfinder.microservices.fitfinder.gymService.service.GymService;

import java.util.List;

@RestController
@RequestMapping("/gym")
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
    public List<String> getOpeningHours(@PathVariable("name") String name) {
        return gymService.getOpeningHoursOfGym(name);
    }

    @PostMapping("/{gymId}/addEquipment")
    public GymGear addGymEquipment(@PathVariable int gymId, @RequestBody EquipmentGymGearDTO gymGearName) {
        return gymService.addGymGear(gymId, gymGearName);
    }

    @GetMapping("/search")
    public List<Gym> findGyms(@RequestParam(required = false) String city, @RequestParam(required = false) String gymName) {
        return gymService.findGymsByCityAndName(city, gymName);
    }

    @GetMapping("/{id}/equipment")
    public List<GymGear> findGyms(@PathVariable String id) {
        return gymService.findEquipmentById(id);
    }

    @PostMapping("/{id}/addAdmin")
    public ResponseEntity<String> addGymAdmin(@RequestHeader("token") String token, @PathVariable int id) {
        String result = gymService.addGymAdmin(token, id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/getAdmins")
    public List<User> getAdmins(@PathVariable int id) {
        return gymService.getGymAdmins(id);
    }

    @GetMapping("/{id}/getInformationWithEquipment")
    public GymWithEquipment getInformationWithEquipment(@PathVariable int id) {
        return gymService.getInformationWithEquipment(id);
    }

    @DeleteMapping("/{id}/delete/{equipmentId}")
    public void deleteEquipment(@PathVariable int id, @PathVariable int equipmentId) {
        gymService.deleteEquipment(id, equipmentId);
    }
}