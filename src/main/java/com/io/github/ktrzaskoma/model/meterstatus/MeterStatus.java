package com.io.github.ktrzaskoma.model.meterstatus;


import com.io.github.ktrzaskoma.model.meter.Meter;

import javax.persistence.*;

@Entity
public class MeterStatus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "meter_status_id")
    private Integer id;

    @Column(name = "measurement")
    private String measurement;

    @Column(name = "taxToPay")
    private String taxToPay;

    @ManyToOne
    @JoinColumn(name = "meter_id", nullable = false)
    private Meter meter;


    public MeterStatus() {}

    public MeterStatus(String measurement) {
        this.measurement = measurement;
        this.meter = new Meter(meter.getMeterNumber());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    public String getTaxToPay() {
        return taxToPay;
    }

    public void setTaxToPay(String taxToPay) {
        this.taxToPay = taxToPay;
    }


    public void updateMeterStatus(final MeterStatus source) {
        measurement = source.measurement;
        taxToPay = source.taxToPay;
    }
}
