package com.cabdriver.Cab.Driver.repository;

import com.cabdriver.Cab.Driver.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


}
