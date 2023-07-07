package com.io.github.ktrzaskoma.model.meterstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterStatusRepository extends JpaRepository<MeterStatus, Integer> {
}