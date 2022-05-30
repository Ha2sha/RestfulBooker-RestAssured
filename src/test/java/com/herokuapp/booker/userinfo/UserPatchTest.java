package com.herokuapp.booker.userinfo;

import com.herokuapp.booker.model.UserPojo;
import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPatchTest extends TestBase {
    @Test
    public void updateUserWithPut(){
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2019-01-01");
        bookingsDatesData.put("checkout", "2020-01-01");

        UserPojo userPojo = new UserPojo();
        userPojo.setFirstname("Harry");
        userPojo.setBookingdates(bookingsDatesData);
        userPojo.setAdditionalneeds("Vegetarian");

        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","password123")
                .body(userPojo)
                .pathParam("id",1075)
                .when()
                .patch("/booking/{id}");

        response.then().statusCode(200);
        response.prettyPrint();
    }

}
