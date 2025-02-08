package com.cabdriver.Cab.Driver.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Driver {
    @Id
    private int id;
    @Column(unique=true)
    private String licenseID;
    private String vehicleType;
    private String firstName;
    private String lastName;
    @Column(length = 10,unique=true,nullable=false)
    private  Long phoneNumber;
    @Column(unique=true)
    private String emailID;
    private String password;
    private Double rating;
    int totalRideServed;


    @OneToMany(mappedBy="driver")
    private List<Booking> bookings;


    public Driver() {
    }

    public Driver(int id, String licenseID, String vehicleType, String firstName, String lastName, Long phoneNumber, String emailID, String password, Double rating, int totalRideServed) {
        this.id = id;
        this.licenseID = licenseID;
        this.vehicleType = vehicleType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.password = password;
        this.rating = rating;
        this.totalRideServed = totalRideServed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(String licenseID) {
        this.licenseID = licenseID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getTotalRideServed() {
        return totalRideServed;
    }

    public void setTotalRideServed(int totalRideServed) {
        this.totalRideServed = totalRideServed;
    }
}
