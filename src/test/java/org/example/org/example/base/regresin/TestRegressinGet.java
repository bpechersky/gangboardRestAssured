package org.example.org.example.base.regresin;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.PetStoreSwagger;
import org.example.RegresinHelper;
import org.example.RestfulBooker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegressinGet {
    RegresinHelper regresinHelper = new RegresinHelper();
    PetStoreSwagger petStoreSwagger = new PetStoreSwagger();
    RestfulBooker restfulBooker = new RestfulBooker();

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
    public void testingBookingGetBookingByName() {
        RestAssured.given()
                .queryParams("firstname", "Sally","lastname","Brown")
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .prettyPrint();
    }

    @Test
    public void testPathParamGetBookingById() {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .pathParam("id",2)
                .when()
                .get("/{id}")
                .prettyPrint();
    }
}
