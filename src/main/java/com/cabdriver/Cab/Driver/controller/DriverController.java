package com.cabdriver.Cab.Driver.controller;


import com.cabdriver.Cab.Driver.models.Driver;
import com.cabdriver.Cab.Driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {


    @Autowired
    DriverService driverService;
    @PostMapping("/api/driver/register")
    public String createAccount(@RequestBody Driver driver)
    {
        driverService.registerDriver(driver);
        return "Driver got successfully registered";
    }
}
