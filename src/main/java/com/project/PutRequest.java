package com.project;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PutRequest {

    @Test
    public void test_01_put(){

        JSONObject request = new JSONObject();

        request.put("name", "morpheus");
        request.put("job", "zion resident");

        System.out.println(request);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString());
        when()
                .post("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }
}
