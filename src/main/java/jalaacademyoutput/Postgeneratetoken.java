package jalaacademyoutput;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Postgeneratetoken {
	public static String bearerToken;
	@Test
	void test1() {
	HashMap<String,String> datab=new HashMap<String,String>();
	datab.put("email", "eve.holt@reqres.in");
   datab.put("password", "cityslicka");
	
	System.out.println(datab);
	JSONObject  request= new JSONObject(datab);
	

	
	
	


    // given() method of RestAssured class to get a reference for RequestSpecification
    Response response = given()
            .header("Accept", "application/json")
            .contentType(ContentType.JSON)
            .and()
            .body(request.toString()).when()
            .post("https://reqres.in/api/login").then()
            .extract()
            .response();

    int statusCode = response.statusCode();

   System.out.println(statusCode);

    if (statusCode == 200) {

        bearerToken = response.jsonPath().getString("token"); // Stores the generated token
        System.out.println("Token Value :" + bearerToken);

    }
    else {
        /**
         *  400 Bad Request response status code
         * indicates that the server cannot or will not process the request due to something that is perceived to be a client error
         */
        System.out.println("Check Your Credentials");

    }

}
}
