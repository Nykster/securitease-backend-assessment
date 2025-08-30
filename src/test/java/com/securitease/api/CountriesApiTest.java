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

    // Scenario 1: Validate that the API response conforms to the JSON schema.
    @Test
    public void testApiResponseConformsToSchema() {
        given()
            .queryParam("fields", "name,languages")
        .when()
            .get("/all") // HTTP GET request to /all endpoint
        .then()
            .assertThat()
            .statusCode(200) // confirmation request has been successful (HTTP 200 OK)
            .body(matchesJsonSchemaInClasspath("countries-schema.json")); // response body compared to my derived schema
    }

    //Scenario 2: Confirmation of total number of countries returned by the API.
    @Test
    public void testTotalNumberOfCountries() {
        given()
            .queryParam("fields", "cca2") // return only two-letter country code for each entry
        .when()
            .get("/all") // use the /all endpoint
        .then()
            .assertThat()
            .statusCode(200)
            .body("size()", equalTo(250)); // assert that the number of countries returned equals 250
    }
    
    //Scenario 3: Validate that South African Sign Language is an official language of South Africa.
    @Test
    public void testSouthAfricaIncludesSignLanguage() {
        given()
            .pathParam("name", "South Africa") // path parameter searches for a specific country by name
        .when()
            .get("/name/{name}") // use the /name/{name} endpoint
        .then()
            .assertThat()
            .statusCode(200)
            .body("[0].languages.values()", hasItem("South African Sign Language")); // assert returned list of languages has item "South African Sign Language"
    }
}