package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.pojos.herokuapp.GetAuthRequest;
import org.example.pojos.herokuapp.GetTokenResponse;

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
    public GetTokenResponse createToken(String userName, String password) throws JsonProcessingException {
        pathParam = "auth";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);
        GetAuthRequest getAuthRequest = new GetAuthRequest(); //create the instance of the request pojo
        getAuthRequest.setUsername(userName); // setting up username
        getAuthRequest.setPassword(password);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(getAuthRequest); // converting the request pojo class to json string

        Response response = RestAssured.given().body(requestJson).contentType(ContentType.JSON).post(finalUrl); // api call
        GetTokenResponse getTokenResponse = objectMapper.readValue(response.prettyPrint(), GetTokenResponse.class); // converting the response to a pojo class
        return getTokenResponse;
    }

}
