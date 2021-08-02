package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.example.pojos.herokuapp.*;

import java.util.ArrayList;
import java.util.List;

public class PetStoreSwagger {
    public static String baseUrl = "https://petstore.swagger.io/";

    BaseHelper baseHelper = new BaseHelper();
    String pathParam;
    String finalUrl;

    public UserResponse getUserName (String userName) throws JsonProcessingException {
        String pathParam = "v2/user/";
        String finalUrl = baseUrl +pathParam+userName;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        UserResponse returnedUserName = objectMapper.readValue(response.prettyPrint(), UserResponse.class);
        return returnedUserName;
    }

    public AvailablePetsResponse getAvailablePets(String status) throws JsonProcessingException {
        String pathParam = "v2/pet/findByStatus?status=";
        String finalUrl = baseUrl +pathParam+status;
        System.out.println("final url is : "+finalUrl);
        Response response = baseHelper.get(finalUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        AvailablePetsResponse availablePetsResponse = objectMapper.readValue(response.prettyPrint(), AvailablePetsResponse.class);// converting the response to a pojo class
        return availablePetsResponse;
    }



    public PetResponse createNewPet(String petName, String status, String tagName, String categoryName, List<String> photoUrls) throws JsonProcessingException {
        pathParam = "v2/pet";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);

        /**
         * creating tag
         */
        Tag tag = new Tag();
        tag.setName(tagName);
        Tag tag1 = new Tag();
        tag1.setName("bantu");


        List tags = new ArrayList();
        tags.add(tag);
        tags.add(tag1);

        /**
         * creating category
         */
        Category category = new Category();
        category.setName(categoryName);

        /**
         * ctreating pet
         */
        PetRequest petRequest = new PetRequest();
        petRequest.setName(petName);
        petRequest.setStatus(status);
        petRequest.setCategory(category);
        petRequest.setTags(tags);//setting list of tags
        petRequest.setPhotoUrls(photoUrls);



        PostPetSwagger newPet = new PostPetSwagger(); //create the instance of the request pojo
        newPet.setName("Misha"); // setting up username
        newPet.setStatus("available");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(petRequest); // converting the request pojo class to json string

        Response response = RestAssured.given().body(requestJson).contentType(ContentType.JSON).post(finalUrl); // api call
        PetResponse petResponse = objectMapper.readValue(response.prettyPrint(), PetResponse.class);// converting the response to a pojo class
        return petResponse;
    }
    public CreateUserWithArrayResponseBody createUserWithArray(String userName, String firstName, String lastName, String password) throws JsonProcessingException {
        pathParam = "v2/user/createWithArray";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);
        CreateUserWithArrayRequestBody requestBody = new CreateUserWithArrayRequestBody();
        requestBody.setFirstName(userName);
        requestBody.setFirstName(firstName);
        requestBody.setLastName(lastName);
        requestBody.setPassword(password);

        List<CreateUserWithArrayRequestBody> createUserWithArrayRequestBodyList = new ArrayList<>();
        createUserWithArrayRequestBodyList.add(requestBody);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Header> headers = new ArrayList<>(); // creating list of header
        headers.add(new Header("accept", "application/json" )); //adding header to the list
        headers.add(new Header("Content-Type", "application/json" ));
        Headers headersFinal = new Headers(headers);//creating headers
        Response response = baseHelper.post(finalUrl, createUserWithArrayRequestBodyList, headersFinal);//calling the base helper
        CreateUserWithArrayResponseBody createUserWithArrayResponseBody = objectMapper.readValue(response.prettyPrint(), CreateUserWithArrayResponseBody.class);// converting the response to a pojo class
        return createUserWithArrayResponseBody;
    }
    public PetResponse createNewPetNew(String petName, String status, String tagName, String categoryName, List<String> photoUrls) throws JsonProcessingException {
        pathParam = "v2/pet";
        finalUrl = baseUrl+pathParam;
        System.out.println(finalUrl);

        /**
         * creating tag
         */
        Tag tag = new Tag();
        tag.setName(tagName);
        Tag tag1 = new Tag();
        tag1.setName("bantu");


        List tags = new ArrayList();
        tags.add(tag);
        tags.add(tag1);

        /**
         * creating category
         */
        Category category = new Category();
        category.setName(categoryName);

        /**
         * ctreating pet
         */
        PetRequest petRequest = new PetRequest();
        petRequest.setName(petName);
        petRequest.setStatus(status);
        petRequest.setCategory(category);
        petRequest.setTags(tags);//setting list of tags
        petRequest.setPhotoUrls(photoUrls);



        PostPetSwagger newPet = new PostPetSwagger(); //create the instance of the request pojo
        newPet.setName("Misha"); // setting up username
        newPet.setStatus("available");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(petRequest); // converting the request pojo class to json string

        List<Header> headers = new ArrayList<>(); // creating list of header
        headers.add(new Header("accept", ContentType.JSON.name() )); //adding header to the list
        headers.add(new Header("Content-Type", ContentType.JSON.name() ));
        Headers headersFinal = new Headers(headers);//creating headers

        Response response = baseHelper.post(finalUrl, requestJson, headersFinal);//calling the base helper
//        Response response = RestAssured.given().body(requestJson).headers(headersFinal).post(finalUrl); // api call
        PetResponse petResponse = objectMapper.readValue(response.prettyPrint(), PetResponse.class);// converting the response to a pojo class
        return petResponse;
    }
}
