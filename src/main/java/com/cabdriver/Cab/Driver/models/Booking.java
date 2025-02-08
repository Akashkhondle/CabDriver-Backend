package com.cabdriver.Cab.Driver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    private int id;
    @ManyToOne
    Customer customer;
    private int billAmount;
    private String status;
    private String feedback;

    @ManyToOne
    Driver driver;

    public Booking() {
    }

    public Booking(int id, Customer customer, int billAmount, String status, String feedback, Driver driver) {
        this.id = id;
        this.customer = customer;
        this.billAmount = billAmount;
        this.status = status;
        this.feedback = feedback;
        this.driver = driver;
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
}
