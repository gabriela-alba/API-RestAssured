package com.project;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PostRequest {

    @Test
    public void test_01_post(){

        JSONObject request = new JSONObject();

        request.put("name", "morpheus");
        request.put("job", "leader");

        System.out.println(request);

        given()
              .header("Content-Type", "application/json")
              .contentType(ContentType.JSON)
              .accept(ContentType.JSON)
              .body(request.toJSONString());
        when()
              .post("https://reqres.in/api/users")
        .then()
              .statusCode(201)
              .log().all();

    }

}
