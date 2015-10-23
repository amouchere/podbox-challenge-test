package com.amouchere;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasItems;

/**
 * Created by LaBete on 22/10/2015.
 */
public class PodBoxApiTest {

    @Test
    public void chartsNumberTest() {
        get("/charts").then().body("rank", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void schemaValidationTest() {
        get("/charts").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
    }

}
