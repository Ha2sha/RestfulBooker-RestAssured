package com.herokuapp.booker.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {
        //set environment
        RestAssured.baseURI="https://restful-booker.herokuapp.com";//test environment


    }
}
