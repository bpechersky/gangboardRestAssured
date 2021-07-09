package org.example;

import io.restassured.response.Response;
import org.example.BaseHelper;

public class RegresinHelper {
    public static String url = "https://reqres.in/";

    BaseHelper baseHelper = new BaseHelper();

    public Response get(String pathParam){
        Response response = baseHelper.get(url+pathParam);
        return response;
    }
}
