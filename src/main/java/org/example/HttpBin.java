package org.example;

import io.restassured.response.Response;

public class HttpBin {
    public static String baseUrl = "https://httpbin.org/";

    BaseHelper baseHelper = new BaseHelper();
    String pathParam;
    String finalUrl;

    public Response getStatus(String pathParam){
        //String pathParam = "ip";
        String finalUrl = baseUrl +pathParam;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;
    }
}
