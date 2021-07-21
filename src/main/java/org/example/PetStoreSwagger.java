package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.pojos.herokuapp.PostPetSwagger;

public class PetStoreSwagger {
    public static String baseUrl = "https://petstore.swagger.io/";

    BaseHelper baseHelper = new BaseHelper();
    String pathParam;
    String finalUrl;

    public Response getAvailablePets(String status){
        String pathParam = "v2/pet/findByStatus?status=";
        String finalUrl = baseUrl +pathParam+status;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        return response;
    }

    public PostPetSwagger postNewPet(String userName, String password) throws JsonProcessingException {
        pathParam = "auth";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);
        PostPetSwagger newPet = new PostPetSwagger(); //create the instance of the request pojo
        newPet.setName("Misha"); // setting up username
        newPet.setStatus("available");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(newPet); // converting the request pojo class to json string

        Response response = RestAssured.given().body(requestJson).contentType(ContentType.JSON).post(finalUrl); // api call
        PostPetSwagger getPetResponse = objectMapper.readValue(response.prettyPrint(), PostPetSwagger.class); // converting the response to a pojo class
        return getPetResponse;
    }
}
