package com.github.alexsep.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class BitcoinResourceTest {

    @Test
    public void shouldReturnStatus200() {
        given()
                .when().get("bitcoins")
                .then()
                .statusCode(200);
    }

}