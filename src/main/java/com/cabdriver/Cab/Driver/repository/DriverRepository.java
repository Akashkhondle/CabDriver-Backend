package com.cabdriver.Cab.Driver.repository;

import com.cabdriver.Cab.Driver.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

    public Driver findByEmailID(String email);
}
