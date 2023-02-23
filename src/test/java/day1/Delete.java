package day1;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Delete {

	//@Test(priority=1)
	void test2() {
	
	
	
	
	
	given().when().delete("https://reqres.in/api/users/2")
	.then().statusCode(204).log().all();
	
	//204 means no content
	
	
}
	@Test(priority=1)
	void test3() {
	
	
		JSONObject  request= new JSONObject();
		request.put("destination1", "vijayawada1");
		System.out.println(request);
		System.out.println(request.toJSONString());
	
	given().when().delete("https://reqres.in/api/users/2")
	.then().statusCode(204).log().all();
	
	//204 means no content
	
	
}}
