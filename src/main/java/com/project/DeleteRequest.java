package com.project;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteRequest {

    @Test
    public void test_01_delete(){

        when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
