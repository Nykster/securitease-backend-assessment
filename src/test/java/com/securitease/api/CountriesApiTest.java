package com.securitease.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem; // Import the 'hasItem' matcher

public class CountriesApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://restcountries.com/v3.1";
    }

    /**
     * Scenario 1: Validate that the API response conforms to the JSON schema.
     */
    @Test
    public void testApiResponseConformsToSchema() {
        given()
            .queryParam("fields", "name,languages")
        .when()
            .get("/all")
        .then()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("countries-schema.json"));
    }

    /**
     * Scenario 2: Confirm the total number of countries returned by the API.
     */
    @Test
    public void testTotalNumberOfCountries() {
        given()
            .queryParam("fields", "cca2")
        .when()
            .get("/all")
        .then()
            .assertThat()
            .statusCode(200)
            .body("size()", equalTo(250));
    }

    /**
     * Scenario 3: Validate that South African Sign Language is an official language of South Africa.
     */
    @Test
    public void testSouthAfricaIncludesSignLanguage() {
        given()
            // Use a path parameter to search for a specific country by name.
            .pathParam("name", "South Africa")
        .when()
            // Use the /name/{name} endpoint.
            .get("/name/{name}")
        .then()
            .assertThat()
            .statusCode(200)
            // GPath expression to get the list of language values from the first result.
            // Assert that the list of languages has the item "South African Sign Language".
            .body("[0].languages.values()", hasItem("South African Sign Language"));
    }
}