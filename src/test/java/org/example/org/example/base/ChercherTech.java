package org.example.org.example.base;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class ChercherTech {
    @Test
    void test1() {
        RestAssured.given().when()
                .get("https://chercher.tech/sample/api/product/read")
                .then()
                .body("records[0].id", lessThan("6000"))
                .body("records[0].name", equalTo("xyz"))
                .body("records[0].description", equalTo("abc"));
    }
}
