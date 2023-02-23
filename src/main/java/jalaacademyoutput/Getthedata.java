package jalaacademyoutput;


import static io.restassured.RestAssured.given;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

public class Getthedata extends Postgeneratetoken  {

    public static String bearerToken1;

    @BeforeClass
    public  void setup() throws IOException  {


    	Postgeneratetoken	 tokenObj=new Postgeneratetoken();
       
        tokenObj.test1();
        bearerToken1=bearerToken.trim();
        System.out.println("Token in Create User API :"+bearerToken1);



    }

    // Token generation using the JSON format in the body of the Request
    @Test
    public void SearchUsers() {
  

        boolean tokenValue = true;

        Response response = given()
                .header("Authorization", "Bearer " +bearerToken1)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON).when()
                .get("https://reqres.in/api/users?page=2").then().extract().response();


        //put(/1) is the id of the user - Search and pass that user here

        System.out.println("Bearer Token :" + bearerToken1);
        System.out.println("Response Code : " + response.statusCode());

         {
            tokenValue = false;
        }

        System.out.println("Message : " + response.jsonPath().getString("message"));
        Assert.assertEquals(tokenValue, true);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals("User inserted successfully.", response.jsonPath().getString("message"));

    }

}

