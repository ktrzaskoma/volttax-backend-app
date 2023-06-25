package com.io.github.ktrzaskoma.model.location;


import com.io.github.ktrzaskoma.model.user.User;
import com.io.github.ktrzaskoma.model.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class LocationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public LocationController(LocationRepository locationRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/location")
    ResponseEntity<List<Location>> readAllLocations() {
        LOGGER.warn("Exposing all location data");
        return ResponseEntity.ok(locationRepository.findAll());
    }

    @PostMapping("/location")
    ResponseEntity<Location> createLocation (@RequestBody Location toCreate) {
        Location location = locationRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + location.getId())).body(location);
    }


    @PostMapping("/location/{id}")
    ResponseEntity<?> createLocation (@PathVariable Integer id,
                                 @RequestBody Location toCreate) {
        Optional<User> user = userRepository.findById(id);
        toCreate.setUser(user.get());
        Location location = locationRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + location)).body(location);
    }
}
