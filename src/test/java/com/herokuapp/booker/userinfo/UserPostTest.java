package com.herokuapp.booker.userinfo;

import com.herokuapp.booker.model.UserPojo;
import com.herokuapp.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser() {

        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2018-01-01");
        bookingsDatesData.put("checkout", "2019-01-01");

        UserPojo userPojo=new UserPojo();
        userPojo.setFirstname("Hina");
        userPojo.setLastname("Brown");
        userPojo.setTotalprice(111);
        userPojo.setDepositpaid(true);
        userPojo.setBookingdates(bookingsDatesData);
        userPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(userPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

        //1075
    }
}
