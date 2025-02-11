package com.cabdriver.Cab.Driver.controller;


import com.cabdriver.Cab.Driver.exceptions.InvalidOperationException;
import com.cabdriver.Cab.Driver.exceptions.ResourceDoesNotExistException;
import com.cabdriver.Cab.Driver.exceptions.UserNotFound;
import com.cabdriver.Cab.Driver.models.Booking;
import com.cabdriver.Cab.Driver.requestbody.CustomerBookingRequestBody;
import com.cabdriver.Cab.Driver.responsebody.BookingResponseBody;
import com.cabdriver.Cab.Driver.service.BooikingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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



    @PutMapping("/update")
    public ResponseEntity updateBookingStatus(@RequestParam String opr, @RequestParam String email, @RequestParam Integer bookingId)
    {
                try{

                    String response = booikingService.updateBoooking(opr,email,bookingId);

                    return new ResponseEntity(response, HttpStatus.CREATED);
                }
                catch(UserNotFound e)
                {
                    return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
                }
                catch(InvalidOperationException ex)
                {
                    return new ResponseEntity(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
                }
                catch(ResourceDoesNotExistException eg)
                {
                    return new ResponseEntity(eg.getMessage(), HttpStatus.NOT_FOUND);
                }
    }

}
