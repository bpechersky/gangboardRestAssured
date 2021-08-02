package org.example.org.example.base.herokuapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.example.PetStoreSwagger;
import org.example.RestfulBooker;
import org.example.pojos.herokuapp.CreateUserWithArrayResponseBody;
import org.example.pojos.herokuapp.GetTokenResponse;
import org.example.pojos.herokuapp.PetResponse;
import org.example.pojos.herokuapp.UserResponse;
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
    @Test
    public void testGetUserByUserName() throws JsonProcessingException {
        UserResponse userResponse = petStore.getUserName("bp1967");
        System.out.println("username is: " + userResponse);
    }
    @Test
    public void testCreateUserWithArray() throws JsonProcessingException{
        CreateUserWithArrayResponseBody newUserWithArray = petStore.createUserWithArray("jsmith123","John", "Khlebnikov","password");

    }

    @Test
    public void testUpdatePet() {
        petStore.updatePet(123,"ban","cool");
    }

    /*    @Test
       public void testGetAvailablePets() throws JsonProcessingException{
        String requestUrl = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        AvailablePetsResponse[] petStoreAvailablePets = petStore.getAvailablePets("available");
        for (int i = 0; i < petStoreAvailablePets.len-gth; i++) {
            System.out.println(petStoreAvailablePets[i].getName());
        }
//        System.out.println("available pets are : " + availablePets.getName() + " "
//             +   availablePets.getCategory() + " " + availablePets.getTags());

    }*/

}
