package day1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DAY3put {

	@Test(priority=1)
	void test2() {
	
	
	JSONObject  request= new JSONObject();
	request.put("destination1", "vijayawada1");
	System.out.println(request);
	System.out.println(request.toJSONString());
	
	
	given().body(request.toJSONString()).when().put("https://reqres.in/api/users/2")
	.then().statusCode(200).log().all();
	
	
	
	
}
	//@Test(priority=1)
void test3() {
	
	
JSONObject  request= new JSONObject();
request.put("destination1", "vijayawada2");
System.out.println(request);
System.out.println(request.toJSONString());


given().body(request.toJSONString()).when().put("http://localhost:3000/users/1")
.then().statusCode(200).log().all();




}
/**
 * 
 */
//@Test(priority=1)
void test4() {
HashMap<String,Object> datab=new HashMap<String,Object>();
datab.put("firstname", "b");

System.out.println(datab);
JSONObject  request= new JSONObject(datab);

System.out.println(request);
System.out.println(request.toJSONString());


given().body(request.toJSONString()).when().post("http://localhost:3000/users")
.then().statusCode(201).log().all();
Response response1=RestAssured.get("http://localhost:3000/users");
int statuscode=	response1.getStatusCode();
Assert.assertEquals(statuscode,201);



}}

