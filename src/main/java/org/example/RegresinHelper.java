package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RegresinHelper {
    public static String baseUrl = "https://reqres.in/";

    BaseHelper baseHelper = new BaseHelper();

    public Response getUserList(int pageNo){
        String pathParam = "api/users?page=";
        String finalUrl = baseUrl +pathParam+pageNo;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;
    }

    /**
     * https://reqres.in/api/users/2
     *
     * @param userId
     * @return
     */
    public Response getUSerDetails(int userId){
        String pathParam = "api/users/";
        String finalUrl = baseUrl+pathParam+userId;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;

    }
}
