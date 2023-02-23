package day1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Day2_post {
	//@Test(priority=1)
	void test2() {
	HashMap<String,Object> datab=new HashMap<String,Object>();
	datab.put("name", "usharani");
	datab.put("job", "senior engineer");
	datab.put("age", "31");
	System.out.println(datab);
	JSONObject  request= new JSONObject(datab);
	request.put("destination", "vijayawada");
	System.out.println(request);
	System.out.println(request.toJSONString());
	
	
	given().body(request.toJSONString()).when().post("https://reqres.in/api/users")
	.then().statusCode(201).log().all();
	
	
	
	
}
	@Test(priority=1)
		void test3() {
		HashMap<String,Object> datab=new HashMap<String,Object>();
		datab.put("email", "eve.holt@reqres.in");
		datab.put("passowrd", "cityslicka1");
		
		System.out.println(datab);
		JSONObject  request= new JSONObject(datab);
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
	 given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .and()
                .body(request.toString()).when()
                .post(https://reqres.in/api/login)
                	.then()
                .extract()
                .response();

        int statusCode = response.statusCode();

        //  This status code value tells us if HTTP Response was successful or not.

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
