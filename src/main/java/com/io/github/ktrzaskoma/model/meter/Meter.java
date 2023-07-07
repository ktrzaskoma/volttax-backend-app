package com.io.github.ktrzaskoma.model.meter;


import com.io.github.ktrzaskoma.model.location.Location;
import com.io.github.ktrzaskoma.model.meterstatus.MeterStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Meter {

    @Id
    @Column(name = "meter_id")
    private Integer id;

    @Column(name = "METER_NUMBER")
    private Integer meterNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "meter", orphanRemoval = true)
    private Set<MeterStatus> meterStatuses;

    public Meter() {
    }

    public Meter(Integer meterNumber) {
        this.meterNumber = meterNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(Integer meterNumber) {
        this.meterNumber = meterNumber;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}