package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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

    public Response post (Object requestPojo,String url){
        Response response = RestAssured.given().body(requestPojo).contentType(ContentType.JSON).post(url);
        return response;
    }
}
