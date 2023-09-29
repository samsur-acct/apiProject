package com.personal;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClass {

    public Response getBookingDetailsById(String bookingId) {
        RequestSpecification request = RestAssured.given();
        Response response = request.baseUri("https://restful-booker.herokuapp.com")
        .when().log().all()
        .get(String.format("/booking/%s",bookingId));
        return response;

    }

}
