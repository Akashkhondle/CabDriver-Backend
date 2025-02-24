package com.cabdriver.Cab.Driver.models;

import jakarta.persistence.*;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@ToString

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    Customer customer;
    private int billAmount;
    private String status;
    private String feedback;

    @ManyToOne
    Driver driver;

   private String startingLocation;

   private  String endingLocation;

    public Booking() {
    }

    public Booking(int id, Customer customer, int billAmount, String status, String feedback, Driver driver, String startingLocation, String endingLocation) {
        this.id = id;
        this.customer = customer;
        this.billAmount = billAmount;
        this.status = status;
        this.feedback = feedback;
        this.driver = driver;
        this.startingLocation = startingLocation;
        this.endingLocation=endingLocation;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation) {
        this.endingLocation = endingLocation;
    }
}
