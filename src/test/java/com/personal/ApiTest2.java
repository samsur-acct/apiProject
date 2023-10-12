package com.personal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.personal.response.Users;

import io.restassured.response.Response;

public class ApiTest2 {

    ApiClass apiClass = new ApiClass();

    @ParameterizedTest
    @ValueSource(strings = { "587" })
    public void testApiGet_validaData_200Response(String bookingId) throws InterruptedException {
        Response response = apiClass.getBookingDetailsById(bookingId);
        response.prettyPrint();
        assertEquals(200, response.getStatusCode(), "Status Code didn't match");
        Thread.sleep(2000);
    }

    @ParameterizedTest
    @ValueSource(strings = { "3390" })
    public void testApiGet_validaData_200Response2(String bookingId) throws InterruptedException {
        Response response = apiClass.getBookingDetailsById(bookingId);
        response.prettyPrint();
        BookingDetails booking = response.as(BookingDetails.class);
        System.out.println(booking);
        System.out.println("Booking ID: " + booking.getFirstname());
        System.out.println("First Name: " + booking.getLastname());
        System.out.println("Last Name: " + booking.getTotalprice());
        System.out.println("Total Price: " + booking.getAdditionalneeds());
        System.out.println("Booking Dates: " + booking.getBookingdates().getCheckin());

        assertEquals(200, response.getStatusCode(), "Status Code didn't match");
        Thread.sleep(2000);
    }

    @Test
    public void testApiGet_validaData_200R() {
        Response response = apiClass.getBookingDetails();
        response.prettyPrint();
        assertEquals(200, response.getStatusCode(), "Status Code didn't match");
    }

    @Test
    public void testGetAllUsers_200Response() {
        Response response = apiClass.getAllUsers();
        response.prettyPrint();
        assertEquals(200, response.getStatusCode(), "Status Code didn't match");
        
        List<Users> users = Arrays.asList(response.body().as(Users[].class));

        int targetUserId = 99;

        Optional<Users> definedUser = users.stream().filter(user -> user.getId() == targetUserId).findFirst();
        
       // booking.stream().filter(userMe -> userMe.getId()).anyMatch(95);

       System.out.println(definedUser);
    }

}
