package org.example.org.example.base.herokuapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.example.PetStoreSwagger;
import org.example.RestfulBooker;
import org.example.org.example.base.dataProvider.PetData;
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
    public void testAuth() { //add dataProvider here
        Response token = booker.createToken();
        Assert.assertEquals(token.getStatusCode(), 200);
    }
    @Test //add dataProvider here
    public void testAuth1() throws JsonProcessingException {
        GetTokenResponse tokenResponse = booker.createToken("admin", "password123");
        System.out.println("token is : "+tokenResponse.getToken());

    }

    @Test(dataProvider = "pet_data", dataProviderClass = PetData.class)
    public void testCreateNewPet(String x, String y, String z, String categoryName, List photos ) throws JsonProcessingException {

        PetResponse newPet = petStore.createNewPet(x, y, z, categoryName, photos);
        System.out.println("x is : " + newPet.getName());

    }
    @Test//add dataProvider here
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
