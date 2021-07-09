package org.example.org.example.base.regresin;

import io.restassured.response.Response;
import org.example.RegresinHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegressinGet {
    RegresinHelper regresinHelper = new RegresinHelper();

    @Test
    public void testGet(){
        Response response = regresinHelper.get("get");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "code is wrong");
    }
}
