package com.heythem.trainings.testcases;

import com.heythem.trainings.pojo.loginPojo; // the file we built as a public Class
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class studentsTestH {

    @Test
    public void studentLogin() {
        /* String bodyHeyLogin = "{\n" +
                "    \"email\": \"goto@example.com\",\n" +
                "    \"password\": \"paSS123456\"\n" +
                "\n" +
                "}";   */ //very old way we rarly use it
        File bodyHeyLogin = new File("src/test/resources/login.json"); // way better way

        given().baseUri("https://todo.qacart.com")
//                .header("Content-Type", "application/json") // convert txt to json for logins to be approved
                .contentType(ContentType.JSON) // also convert txt to json
                .body(bodyHeyLogin)
                .log().all()
                .when().post("/api/v1/students/login") //create new member/student
                .then().log().all()
                .assertThat().statusCode(200)
        ;
    }

    @Test
    public void studentLogin2() {
        //HasMap way +installing [Jackson Databind] JSON Libraries
        HashMap<String, String> body = new HashMap<>();
        body.put("email", "goto@example.com");
        body.put("password", "paSS123456");
        given().baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON) // still need it here also
                .body(body)
                .log().all()
                .when().post("/api/v1/students/login")
                .then().log().all()
                .assertThat().statusCode(200)
        ;
    }

    @Test
    public void studentLogin3() {
        //Pojo way [the most used]
        loginPojo body = new loginPojo("goto@example.com", "paSS123456"); // way2 + addons in loginPojo
//        loginPojo body = new loginPojo(); // didn't do the autocomplete with me? //update: if u want the line to work again got deactivate the new method in loginPojo
//        body.setEmail("goto@example.com");
//        body.setPassword("paSS123456");
        given().baseUri("https://todo.qacart.com")
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when().post("/api/v1/students/login")
                .then().log().all()
                .assertThat().statusCode(200)
        ;
    }

    public void justToLearn0(){
        //No real test here Learn notes only
        // in case data wasn't Json but in other data type like [x-www-form-urlencoded]      or [multipart/form-data boundary] which is about upload/download files
//        File photo12 = new File("src/test/resources/photo12"); // ~if we use multipart [2]
        HashMap<String, String> formXX7 = new HashMap<>();
        formXX7.put("fouad@yahoo.com", "12345");
        given().baseUri("https://todo.qacart.com")
//                .contentType(ContentType.JSON) // ~if we use multipart but not sure? [2]
                .contentType(ContentType.URLENC)
                .formParams(formXX7)
//                .multiPart("file", "photo12") // ~if we use multipart [2]
                .when().post("/api/v1/")
                .then();
    }

}
