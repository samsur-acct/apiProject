package com.personal.response;

public class BookingDates {
    private String checkin;
    private String checkout;

    // Default constructor
    public BookingDates() {}

    // Getters and setters for both fields
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}