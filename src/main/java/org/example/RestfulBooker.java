package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
public class RestfulBooker {
    public static String baseUrl = "https://restful-booker.herokuapp.com/";

    BaseHelper baseHelper = new BaseHelper();

    public Response getBookingByName(HashMap<String,String> fullName){
        String pathParam = "booking?";
        String finalUrl = baseUrl +pathParam+fullName;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;
    }
}
