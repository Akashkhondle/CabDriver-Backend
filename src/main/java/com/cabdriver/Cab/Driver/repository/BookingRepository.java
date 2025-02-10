package com.cabdriver.Cab.Driver.repository;

import com.cabdriver.Cab.Driver.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


    @Query(value = "select * from booking where status =:state",nativeQuery = true)
    public List<Booking>getBookingByStatus(String state);

}
