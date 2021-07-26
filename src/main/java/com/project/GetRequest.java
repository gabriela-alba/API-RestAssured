package com.project;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest {
    @Test
    public void test_01_get(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_02_get(){
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7))
        .log().all();
    }
}
