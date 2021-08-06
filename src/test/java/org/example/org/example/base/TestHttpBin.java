package org.example.org.example.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.HttpBin;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;



import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestHttpBin {

    HttpBin httpBin = new HttpBin();


    @Test//add dataProvider here
    public void testGetIPAddress() throws JsonProcessingException {
        Response ipAddress = httpBin.getStatus("ip");
        System.out.println("ip address is: " + ipAddress);
    }
    @Test
    void test() {
        given()
                .when()
                .get("https://chercher.tech/sample/api/product/read")
                .prettyPrint();
    }

    @Test
    void testLogging() {
        given()
                .when()
                .log()
                .all()
                .get("https://chercher.tech/sample/api/product/read");
    }

    @Test
    void testLogging1() {
        given()
                .when()
                .log().all() // after preparing request but not yet send to server
                .get("https://chercher.tech/sample/api/product/read")
                .then()
                .log().all(); // after receiving the response from server
    }

    @Test
    void testLogging2() {
        given()
                .when()
                .get("https://chercher.tech/jsdbvbkv") // url supplied doenot exist, so result in error
                .then()
                .log().status();
    }

    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI="https://maps.googleapis.com";

    }

    @Test
    public void logTest() {

        given()
                .param ("query", "Churchgate Station")
                .param ("key","Xyz" )
                .when ()
                .log ()
                .all ()
                .get ("/maps/api/place/textsearch/json");

    }
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.port = 443;
    }
    @Test
    public void whenLogRequest_thenOK() {
        given().log().all()
                .when().get("/users/eugenp")
                .then().statusCode(200);
    }
    @Test
    public void whenLogResponse_thenOK() {
        when().get("/repos/eugenp/tutorials")
                .then().log().body().statusCode(200);
    }



    @BeforeAll
    public static void setup1() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";

}
