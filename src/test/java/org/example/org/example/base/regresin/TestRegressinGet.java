package org.example.org.example.base.regresin;

import io.restassured.response.Response;
import org.example.PetStoreSwagger;
import org.example.RegresinHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegressinGet {
    RegresinHelper regresinHelper = new RegresinHelper();
    PetStoreSwagger petStoreSwagger = new PetStoreSwagger();

    /**
     * https://reqres.in/api/users?page=2    //user list
     * /api/users/2 //user details
     */

    @Test
    public void testGetUserLIst(){
        Response response = regresinHelper.getUserList(2);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "code is wrong");
    }

    @Test
    public void testGetUserDetails() {
        Response uSerDetails = regresinHelper.getUSerDetails(2);
        int statusCode = uSerDetails.getStatusCode();
        Assert.assertEquals(statusCode,200, "unexpected behaviour");
    }

    @Test
    public void testAvailablePets() {
        Response uSerDetails = petStoreSwagger.getAvailablePets("available");
        int statusCode = uSerDetails.getStatusCode();
        Assert.assertEquals(statusCode,200, "unexpected behaviour");
    }
}
