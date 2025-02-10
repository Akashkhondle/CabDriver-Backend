package com.cabdriver.Cab.Driver.requestbody;


//import lombok.*;
//
//@ToString
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class CustomerBookingRequestBody {
    private String startingLocation;
    private String endingLocation;

    public CustomerBookingRequestBody(String startingLocation, String endingLocation) {
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(String endingLocation) {
        this.endingLocation = endingLocation;
    }
}
