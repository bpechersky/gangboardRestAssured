package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.pojos.herokuapp.GetAuthRequest;

import java.util.HashMap;

public class RestfulBooker {
    public static String baseUrl = "https://restful-booker.herokuapp.com/";

    BaseHelper baseHelper = new BaseHelper();
    String pathParam;
    String finalUrl;

    public Response getBookingByName(HashMap<String,String> fullName){
        pathParam = "booking?";
        finalUrl = baseUrl +pathParam+fullName;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;
    }

    public Response createToken(){
        pathParam = "auth";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);
        String body = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(body).post(finalUrl);
        response.prettyPrint();
        return response;
    }
    public Response createToken(String userName, String password){
        pathParam = "auth";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);
        GetAuthRequest getAuthRequest = new GetAuthRequest();
        getAuthRequest.setUsername(userName);
        getAuthRequest.setPassword(password);

        Response response = RestAssured.given().body(getAuthRequest).contentType(ContentType.JSON).post(finalUrl);
        response.prettyPrint();
        return response;
    }

}
