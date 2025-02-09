 package com.cabdriver.Cab.Driver.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

 @NoArgsConstructor
 @AllArgsConstructor
 @Getter
 @Setter
 @ToString

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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







}
