package org.example;

import io.restassured.RestAssured;
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

    public void post (Object requestPojo){

    }
}
