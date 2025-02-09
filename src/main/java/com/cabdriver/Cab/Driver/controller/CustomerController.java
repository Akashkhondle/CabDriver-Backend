package com.cabdriver.Cab.Driver.controller;


import com.cabdriver.Cab.Driver.exceptions.UserNotFound;
import com.cabdriver.Cab.Driver.models.Customer;
import com.cabdriver.Cab.Driver.requestbody.UserCredentialsRequestBody;
import com.cabdriver.Cab.Driver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @PostMapping("/api/customer/register")
    public String createAccount(@RequestBody Customer customer)
    {
        //System.out.println(customer);
        customerService.registerAccount(customer);
        return "Account created successfully";
    }

    @GetMapping("/api/customer/authenticate")
    public String loginCustomer(@RequestBody UserCredentialsRequestBody userCredentialsRequestBody)
    {
          String email = userCredentialsRequestBody.getEmail();
          String password = userCredentialsRequestBody.getPassword();

          try{
              return customerService.authenticateCustomer(email,password);
          }
          catch(UserNotFound e)
          {
              return e.getMessage();
          }


    }
}
