package com.cabdriver.Cab.Driver.responsebody;

public class BookingResponseBody {
    private int bookingID;
    private int customerID;
    private String customerName;
    private String startingLocation;
    private String endingLocation;
    private int billingAmount;
    private String status;

    public BookingResponseBody() {
    }

    public BookingResponseBody(int bookingID, int customerID, String customerName, String startingLocation, String endingLocation, int billingAmount, String status) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.billingAmount = billingAmount;
        this.status = status;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public int getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(int billingAmount) {
        this.billingAmount = billingAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
