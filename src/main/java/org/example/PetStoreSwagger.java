package org.example;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;
public class PetStoreSwagger {
    public static String baseUrl = "https://petstore.swagger.io/";

    BaseHelper baseHelper = new BaseHelper();

    public Response getAvailablePets(String status){
        String pathParam = "v2/pet/findByStatus?status=";
        String finalUrl = baseUrl +pathParam+status;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;
    }
}
