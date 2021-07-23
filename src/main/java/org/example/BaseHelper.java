package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

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
    public Response post (String url, Object body, Headers headers){
        Response response = RestAssured.given().body(body).headers(headers).post(url);
        return response;
    }
}
