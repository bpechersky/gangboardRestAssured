package org.example.org.example.base.herokuapp;

import io.restassured.response.Response;
import org.example.RestfulBooker;
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
    public void testAuth1() {
        Response token = booker.createToken("admin","password123");
        Assert.assertEquals(token.getStatusCode(), 200);
    }

}
