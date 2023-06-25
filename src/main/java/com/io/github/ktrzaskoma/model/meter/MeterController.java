package com.io.github.ktrzaskoma.model.meter;


import com.io.github.ktrzaskoma.model.location.Location;
import com.io.github.ktrzaskoma.model.location.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class MeterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeterController.class);
    private final MeterRepository meterRepository;
    private final LocationRepository locationRepository;

    MeterController(MeterRepository meterRepository, LocationRepository locationRepository) {
        this.meterRepository = meterRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/meters")
    ResponseEntity<List<Meter>> readAllMeters() {
        LOGGER.warn("Exposing all the volt counters!");
        return ResponseEntity.ok(meterRepository.findAll());
    }

    @PostMapping("/meters")
    ResponseEntity<Meter> createMeter(@RequestBody Meter toCreat){
        Meter meter = meterRepository.save(toCreat);
        return  ResponseEntity.created(URI.create("/" + meter.getId())).body(meter);
    }

    @PostMapping("/meters/{id}")
    ResponseEntity<?> createMeter (@PathVariable Integer id,
                                      @RequestBody Meter toCreate) {
        Optional<Location> location = locationRepository.findById(id);
        toCreate.setLocation(location.get());
        Meter meter = meterRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + meter)).body(meter);
    }
}
