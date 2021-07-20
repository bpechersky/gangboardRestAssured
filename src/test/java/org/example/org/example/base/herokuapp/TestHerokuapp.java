package org.example.org.example.base.herokuapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.example.RestfulBooker;
import org.example.pojos.herokuapp.GetTokenResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHerokuapp {

    RestfulBooker booker = new RestfulBooker();
    @Test
    public void testAuth() {
        Response token = booker.createToken();
        Assert.assertEquals(token.getStatusCode(), 200);
    }
    @Test
    public void testAuth1() throws JsonProcessingException {
        GetTokenResponse tokenResponse = booker.createToken("admin", "password123");
        System.out.println("token is : "+tokenResponse.getToken());

    }

}
