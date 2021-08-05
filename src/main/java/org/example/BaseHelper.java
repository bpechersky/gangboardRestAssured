package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class BaseHelper {

    private void printResponse(Response response) {
        System.out.println("=============RESPONSE==============");
        response.then().log().all();
    }

    /**
     * get
     * @param urlParam
     * @return
     */
    public Response get(String urlParam){
        Response response = RestAssured.given().when().log().all().get(urlParam);
        printResponse(response);
        return response;
    }

    /**
     *
     * @param url
     * @param body
     * @param headers
     * @return
     */
    public Response post (String url, String body, Headers headers){
        System.out.println("body is:");
        System.out.println(body);
        Response response = RestAssured.given().body(body.getBytes(StandardCharsets.UTF_8)).headers(headers).post(url);
        printResponse(response);
        return response;
    }
    public Response post (String url, Object body, Headers headers){
//        System.out.println("body is:");
//        System.out.println(body);
        Response response = RestAssured.given().when().log().all().body(body).headers(headers).post(url);
        printResponse(response);
        return response;
    }



    public Response postWithFormData (String url, Map<String, String> body, Headers headers){
        Response response = RestAssured.given().urlEncodingEnabled(true).formParams(body).headers(headers).post(url); //urlEncoding Enabled and passing the form param as map
        printResponse(response);
        return response;

    }



}
