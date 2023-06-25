package com.io.github.ktrzaskoma.model.meterstatus;


import com.io.github.ktrzaskoma.model.meter.Meter;
import com.io.github.ktrzaskoma.model.meter.MeterController;
import com.io.github.ktrzaskoma.model.meter.MeterRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class MeterStatusController {

    private static final Logger logger = LoggerFactory.getLogger(MeterController.class);
    private final MeterStatusRepository meterStatusRepository;
    private final MeterRepository meterRepository;

    private final MeterStatusService meterStatusService;

    MeterStatusController(final MeterStatusRepository meterStatusRepository, MeterRepository meterRepository, MeterStatusService meterStatusService) {
        this.meterStatusRepository = meterStatusRepository;
        this.meterRepository = meterRepository;
        this.meterStatusService = meterStatusService;
    }

    @GetMapping("/meter/status")
    ResponseEntity<List<MeterStatus>> readAllMeters() {
        logger.warn("Exposing all the volt counters!");
        return ResponseEntity.ok(meterStatusRepository.findAll());
    }

    @PostMapping("/meter/status/{id}")
    ResponseEntity<?> createMeterStatus(@PathVariable Integer id,
                                        @RequestBody MeterStatus toCreate) {
        Optional<Meter> meter = meterRepository.findById(id);
        toCreate.setMeter(meter.get());
        toCreate.setTaxToPay(meterStatusService.meterCalculator(toCreate));
        MeterStatus meterStatus = meterStatusRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + meterStatus)).body(meterStatus);
    }

    @PutMapping ("/meter/status/{id}")
    ResponseEntity<?> updateTaxToPay(@PathVariable Integer id,
                                     @RequestBody @Valid MeterStatus toUpdate) {
        if (!meterStatusRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        meterStatusRepository.findById(id)
                .ifPresent(status -> {
                    status.updateMeterStatus(toUpdate);
                    meterStatusRepository.save(status);
                });
        return ResponseEntity.noContent().build();

    }
}
