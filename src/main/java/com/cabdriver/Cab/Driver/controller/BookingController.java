package com.cabdriver.Cab.Driver.controller;


import com.cabdriver.Cab.Driver.exceptions.UserNotFound;
import com.cabdriver.Cab.Driver.models.Booking;
import com.cabdriver.Cab.Driver.requestbody.CustomerBookingRequestBody;
import com.cabdriver.Cab.Driver.responsebody.BookingResponseBody;
import com.cabdriver.Cab.Driver.service.BooikingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {


    @Autowired
    BooikingService booikingService;

    @PostMapping("/request")
    public String createCustomerBooking(@RequestBody CustomerBookingRequestBody customerBookingRequestBody, @RequestParam int customerId)
    {
           String startingLocation = customerBookingRequestBody.getStartingLocation();
        String endingLocation = customerBookingRequestBody.getEndingLocation();

        try{
            booikingService.handleCustomerRequest(startingLocation,endingLocation,customerId);
            return "Waiting for driver to accept";
        }
        catch(UserNotFound e)
        {
            return e.getMessage();
        }


    }

    @GetMapping("/all")
    public List<BookingResponseBody> getBookingByStatus(@RequestParam String state)
    {
        return booikingService.getBookingByStatus(state);
    }


}
