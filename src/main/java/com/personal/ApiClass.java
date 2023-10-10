package com.personal;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.response.BookingDetails;
import com.personal.response.Users;
import com.personal.response.UsersClass;

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

    public List<BookingDetails> getBookingDetailsObject(String id) {

        var details = Arrays.asList(getBookingDetailsById2(id).body().as(BookingDetails[].class));
        return details;
    }

    public Response getUsersById(int userId) {
        RequestSpecification request = RestAssured.given();
        Response response = request.baseUri("https://jsonplaceholder.typicode.com")
                .when().log().all()
                .get(String.format("/posts/%s", userId));
        return response;
    }

    public UsersClass getUsersByIdObject(int id) throws JsonMappingException, JsonProcessingException {

        var response = getUsersById(id);
        if(response.getStatusCode() == 200){
            response.prettyPrint();
            // ObjectMapper objectMapper = new ObjectMapper();
            // return objectMapper.readValue(response.getBody().asString(), Users.class);
            return response.body().as(UsersClass.class);




        }else return null;
        
    }

}
