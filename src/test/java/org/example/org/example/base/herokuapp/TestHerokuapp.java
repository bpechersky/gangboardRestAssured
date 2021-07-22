package org.example.org.example.base.herokuapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.example.PetStoreSwagger;
import org.example.RestfulBooker;
import org.example.pojos.herokuapp.GetTokenResponse;
import org.example.pojos.herokuapp.PetResponse;
import org.example.pojos.herokuapp.PostPetSwagger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHerokuapp {

    RestfulBooker booker = new RestfulBooker();
    PetStoreSwagger petStore = new PetStoreSwagger();
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

    @Test
    public void testCreateNewPet() throws JsonProcessingException {
        List photos = new ArrayList();
        photos.add("url1");
        PetResponse newPet = petStore.createNewPet("Leena", "available", "Dog", "DogC", photos);
        System.out.println("name is : " + newPet.getName());
    }

}
