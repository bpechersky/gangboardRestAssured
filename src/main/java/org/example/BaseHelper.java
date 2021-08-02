package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class BaseHelper {

    /**
     * get
     * @param urlParam
     * @return
     */
    public Response get(String urlParam){
        Response response = RestAssured.get(urlParam);
        response.prettyPrint();
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
        return response;
    }
    public Response post (String url, Object body, Headers headers){
        System.out.println("body is:");
        System.out.println(body);
        Response response = RestAssured.given().body(body).headers(headers).post(url);
        return response;
    }

    public Response post (String url, Map<String, String> body, Headers headers){
        System.out.println("body is:");
        System.out.println(body);
        Response response = RestAssured.given().urlEncodingEnabled(true).formParams(body).headers(headers).post(url); //urlEncoding Enabled and passing the form param as map
        return response;
    }


}
