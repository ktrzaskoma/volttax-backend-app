package com.io.github.ktrzaskoma.model.location;


import com.io.github.ktrzaskoma.model.meter.Meter;
import com.io.github.ktrzaskoma.model.user.User;

import javax.persistence.*;

@Entity
public class Location {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "location_id")
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "buildingOrApartmentNumber")
    private String buildingOrApartmentNumber;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "voivodeship")
    private String voivodeship;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Meter meter;

    public Location() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingOrApartmentNumber() {
        return buildingOrApartmentNumber;
    }

    public void setBuildingOrApartmentNumber(String buildingOrApartmentNumber) {
        this.buildingOrApartmentNumber = buildingOrApartmentNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
