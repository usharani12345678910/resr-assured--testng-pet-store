package day1;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Patch {

	@Test(priority=1)
	void test2() {
	
	
	JSONObject  request= new JSONObject();
	request.put("destination1", "vijayawada");
	System.out.println(request);
	System.out.println(request.toJSONString());
	
	
	given().body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	
	
	
	
}
	//@Test(priority=1)
		void test3() {
		
		
		JSONObject  request= new JSONObject();
		request.put("destination1", "vijayawada1");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		given().body(request.toJSONString()).when().patch("http://localhost:3000/users/4").then().statusCode(200).log().all();
		
		}}

