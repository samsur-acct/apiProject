package com.personal;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClass {

    public Response getBookingDetailsById(String bookingId) {
        RequestSpecification request = RestAssured.given();
        Response response = request.baseUri("https://restful-booker.herokuapp.com")
                .when().log().all()
                .get(String.format("/booking/%s", bookingId));
        return response;
    }

    public Response getAllUsers() {
        RequestSpecification request = RestAssured.given();
        Response response = request.baseUri("https://jsonplaceholder.typicode.com")
                .when().log().all()
                .get("/posts");
        return response;
    }

    public Response getBookingDetailsById2(String bookingId) {
        RequestSpecification request = RestAssured.given();
        Response response = request.baseUri("https://restful-booker.herokuapp.com")
                .when().log().all()
                .get(String.format("/booking/%s", bookingId));
        return response;
    }

    public Response getBookingDetails() {
        RequestSpecification request = RestAssured.given();
        Response response = request.baseUri("https://restful-booker.herokuapp.com")
                .when().log().all()
                .get("/booking");
        return response;
    }

}
