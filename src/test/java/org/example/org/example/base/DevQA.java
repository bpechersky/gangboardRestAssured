package org.example.org.example.base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static io.restassured.RestAssured.given;
public class DevQA {

    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";
    private static String putRequestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"baz\",\n" +
            "  \"userId\": \"1\",\n" +
            "  \"id\": \"1\" \n}";
    private static String patchRequestBody = "{\n" +
            "  \"title\": \"bax\" \n}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }
    @Test
    public void putRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(putRequestBody)
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("baz", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));
    }
    @Test
    public void patchRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(patchRequestBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("bax", response.jsonPath().getString("title"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));
    }
    @Test
    public void deleteRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }
    public static String clientId = "some_client_id";
    public static String redirectUri = "some_redirect_uri";
    public static String scope = "some_scope";
    public static String username = "some_email";
    public static String password = "some_password";

    public static String encode(String str1, String str2) {
        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
    }

    public static Response getCode() {
        String authorization = encode(username, password);

        return
                given()
                        .header("authorization", "Basic " + authorization)
                        .contentType(ContentType.URLENC)
                        .formParam("response_type", "code")
                        .queryParam("client_id", clientId)
                        .queryParam("redirect_uri", redirectUri)
                        .queryParam("scope", scope)
                        .post("/oauth2/authorize")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public static String parseForOAuth2Code(Response response) {
        return response.jsonPath().getString("code");
    }

    @BeforeAll
    public static void setup1() {
        RestAssured.baseURI = "https://some-url.com";
    }

    @Test
    public void iShouldGetCode() {
        Response response = getCode();
        String code = parseForOAuth2Code(response);

        Assertions.assertNotNull(code);
    }

    @Test
    public void submitForm() {
        RestAssured.baseURI = "https://www.example.com";
        given().urlEncodingEnabled(true)
                .param("username", "user@site.com")
                .param("password", "Pas54321")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(200);
    }
    private static String payload = "{\n" +
            "  \"description\": \"Some Description\",\n" +
            "  \"id\": \"Some id\",\n" +
            "  \"name\": \"Some name\"\n" +
            "}";

    public static Response postJsonPayload() {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .post("/some/resource")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }
}
