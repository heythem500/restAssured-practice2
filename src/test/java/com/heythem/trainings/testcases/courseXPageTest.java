package com.heythem.trainings.testcases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class courseXPageTest {

@Test
    public void showCourseXPageINFO() {
    //[issue] because the link is wrong
    //before the auth code = "message": "Unauthorized, please insert a correct token"
    //after writing the auth = "message": "Something went wrong, please try again"
        given().baseUri("https://todo.qacart.com")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2MzA1ZDY2ZmUyNDQ2MDAxNDFiNjMyYyIsImZpcnN0TmFtZSI6ImdvdG8iLCJsYXN0TmFtZSI6InBhU1MxMjM0NTYiLCJpYXQiOjE3MTQ1MzY2OTJ9.WZELU6QQoR4x9xcTIDARFeA7mE6gfl2EIoI6RBuLfb4")
//                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2MjFiNWJmYTI5MzRhMDAxNDI4ZDRhNyIsImZpcnN0TmFtZSI6IkhhdGVtIiwiaWF0IjoxNzE0NTMzOTczfQ.l3nf295-PGOv8JZL5pACxb-lk7mY6JYb2_dlwGGjlhg")
                .log().all()
                .when().get("/api/v1/courses/6319b5655ce1f40db1b73738")
                .then().log().all()
                .assertThat().statusCode(200)
                ;
    }
}
