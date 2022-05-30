package com.herokuapp.booker.userinfo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostAuthTest{

    @Test
    public void createAuthorisation(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/auth";
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post();
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
