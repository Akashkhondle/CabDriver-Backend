 package com.cabdriver.Cab.Driver.models;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer age;
    private String password;
    private String firstname;
    private String lastname;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private Long phoneNumber;
    private String address;

    @OneToMany(mappedBy="customer")
    private List<Booking>bookings;





    public Customer() {
    }

    public Customer(Integer id, Integer age, String password, String firstname, String lastname, String email, Long phoneNumber, String address) {
        this.id = id;
        this.age = age;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
