package com.cabdriver.Cab.Driver.service;


import com.cabdriver.Cab.Driver.exceptions.InvalidOperationException;
import com.cabdriver.Cab.Driver.exceptions.ResourceDoesNotExistException;
import com.cabdriver.Cab.Driver.exceptions.UserNotFound;
import com.cabdriver.Cab.Driver.models.Booking;
import com.cabdriver.Cab.Driver.models.Customer;
import com.cabdriver.Cab.Driver.models.Driver;
import com.cabdriver.Cab.Driver.models.User;
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
    DriverService driverService;

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

    public String updateBoooking(String operation,String email,Integer bookingId)
    {
            Customer customer = customerService.getCustomerByEmail(email);
            Driver driver = driverService.getDriverByEmail(email);
            String userType = "";
            User user= null;
            Integer userId = -1;
            if(customer != null)
            {
                userId = customer.getId();
                userType = "CUSTOMER";
                user = customer;
            }
            else if(driver != null)
            {
                userId =driver.getId();
               userType = "DRIVER";
               user = driver;
            }
            else
            {
                throw  new UserNotFound(String.format("User with id %d does not exit",userId));
            }


        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if(booking == null)
        {
            throw new ResourceDoesNotExistException(String.format("Booking with id %d does not exist in System",bookingId));
        }

            if(operation.equals("ACCEPT"))
            {
                if(userType.equals("CUSTOMER"))
                {
                    throw new InvalidOperationException(String.format("Customer can not accept rides"));
                }



                booking.setDriver(driver);
                booking.setStatus("ACCEPTED");
                booking.setBillAmount(100);
                bookingRepository.save(booking);

                return String.format("Driver with id %d accepted booking with %d",userId,bookingId);
            } else if (operation.equals("CANCEL")) {
                if(userType.equals("CUSTOMER"))
                {

                    if(booking.getCustomer().getId() == userId)
                    {
                        booking.setStatus("CANCEL");
                        bookingRepository.save(booking);
                        return String.format("Customer with id %d cancelled ride with booking id %d",userId,bookingId);
                    }
                    else
                    {
                        throw new InvalidOperationException(String.format("Customer with id %d is not allowed to cancel booking with id %d",userId,bookingId));
                    }

                }
                else if(userType.equals("DRIVER"))
                {
                    booking.setStatus("CANCELLED");
                    bookingRepository.save(booking);
                    return String.format("Driver with id %d cancelled booking with id %d",userId,bookingId);
                }
                else
                {
                    throw new InvalidOperationException(String.format("Driver with id %d is not allowed to cancel booking with id %d",userId,bookingId));
                }

            }
            return "";


    }
}
