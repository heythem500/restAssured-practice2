package com.heythem.trainings.testcases;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class infoTestClassH {

    @Test
    public void coursesFromQacart() {
       given().baseUri("https://todo.qacart.com")
               .header("type", "WEB") // let's make request with one header the count will = 1
               .header("language", "spanish") // more headers = more filters , now the count = 0
//               .headers("type", "WEB", "language", "NONE") // or a shortcut line for both
               .log().all() // will show shorted details list about our request like proxy, method, prams etc..
               .when()
               .get("/api/v1/info/courses")
               .then()
               .log().all() //details like Get postman, the whole link has 2 courses only so it's already short
               .assertThat().statusCode(200);
    }

    @Test
    public void coursesFromQacartWay2() {
        // just like way1 but here we'll use objects
        Header header1 = new Header("type", "WEB");
        Header header2 = new Header("language", "JAVA");
        Headers totlaHeaders= new Headers(header1, header2); // if we need to use one object below baseurl

        given().baseUri("https://todo.qacart.com")
//                .header(header1)
//                .header(header2)
                .headers(totlaHeaders) // seems dumb because we'll have to add 1 line of code like above
//                .log().all()
                .when().get("/api/v1/info/courses")
                .then().log().all()
        ;
    }

    @Test
    public void coursesFromQacartWay3() {
        // the HasMap way bcoz this class in the first place support or has key/value pair
        HashMap<String, String> selectYourHeader = new HashMap<>();
        selectYourHeader.put("type", "WEB");
        selectYourHeader.put("language", "JAVA");

        given().baseUri("https://todo.qacart.com")
                .headers(selectYourHeader)
                .when().get("/api/v1/info/courses")
                .then().log().all() // count = 1 course
                .assertThat()
                .statusCode(200)
                .body("count", equalTo(1)); // (successful) if number of courses should be count = 1
    }

    @Test
    public void lecturesHazemB1() {
        given().baseUri("https://todo.qacart.com")
//                .queryParam("type", "PAID")
//                .queryParam("mode", "VIDEO") // = filter to fewer number 4 ~~ same idea of headers
                .queryParams("type", "PAID", "mode", "VIDEO") // alternative for the two together
                .log().all() // to see queryParams info at top
                .when().get("/api/v1/info/lectures")
                .then().log().all(); // total lectures are = 6
    }

    @Test
    public void lecturesHazemB2() {
        //HashMap way just like headers
        HashMap<String, String> quriesHazem = new HashMap<>();
        quriesHazem.put("type", "PAID");
        quriesHazem.put("mode", "VIDEO");
        given().baseUri("https://todo.qacart.com")
                .queryParams(quriesHazem)
                .log().all()
                .when().get("/api/v1/info/lectures")
                .then().log().all();
    }

} // The End
