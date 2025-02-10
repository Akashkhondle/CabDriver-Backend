package com.cabdriver.Cab.Driver.repository;

import com.cabdriver.Cab.Driver.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findByEmail(String email);


}
