package com.cabdriver.Cab.Driver.service;


import com.cabdriver.Cab.Driver.exceptions.UserNotFound;
import com.cabdriver.Cab.Driver.models.Booking;
import com.cabdriver.Cab.Driver.models.Customer;
import com.cabdriver.Cab.Driver.repository.BookingRepository;
import com.cabdriver.Cab.Driver.responsebody.BookingResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooikingService {

    @Autowired
    CustomerService customerService;

    @Autowired
    BookingRepository bookingRepository;
    public void handleCustomerRequest(String startingLocation, String endingLocation,int customerId)
    {
       Customer customer = customerService.getCustomerById(customerId);
       if(customer == null)
       {
           throw new UserNotFound(String.format("User with id %d does not exist",customerId));
       }

        Booking booking = new Booking();
       booking.setCustomer(customer);
       booking.setStatus("Draft");
       booking.setBillAmount(0);
       booking.setStartingLocation(startingLocation);
       booking.setEndingLocation(endingLocation);

       bookingRepository.save(booking);




    }

    public List<BookingResponseBody> getBookingByStatus(String state)
    {
       List<Booking> bookingList =bookingRepository.getBookingByStatus(state);
       List<BookingResponseBody> bookingResponseBodyList = new ArrayList<>();

       for(Booking booking:bookingList)
       {
           BookingResponseBody bookingResponseBody = new BookingResponseBody();
           bookingResponseBody.setBookingID(booking.getId());
           bookingResponseBody.setCustomerID(booking.getCustomer().getId());
           bookingResponseBody.setCustomerName(booking.getCustomer().getFirstname());
           bookingResponseBody.setStartingLocation(booking.getStartingLocation());
           bookingResponseBody.setEndingLocation(booking.getEndingLocation());
           bookingResponseBody.setBillingAmount(booking.getBillAmount());
           bookingResponseBody.setStatus(booking.getStatus());
           bookingResponseBodyList.add(bookingResponseBody);

       }

       return bookingResponseBodyList;
    }
}
