package com.herokuapp.booker.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    //1.Find Total records
    @Test
    public void test001() {
        int records = response.extract().path("size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + records);
        System.out.println("------------------End of Test---------------------------");
    }



}
