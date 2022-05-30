package com.herokuapp.booker.userinfo;

import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersInfo() {
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo() {
        Response response = given()
                .pathParam("id", 659)
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
