package com.io.github.ktrzaskoma.model.meter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeterRepository extends JpaRepository<Meter, Integer> {

    List<Meter> findAll();
    Optional<Meter> findById(Integer id);

}
