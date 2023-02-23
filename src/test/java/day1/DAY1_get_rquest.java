package day1;



import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;



public class DAY1_get_rquest {
	public static String bearerToken;
	//@Test
	public void test1() {
	//specify the url
Response response=RestAssured.get("http://localhost:3000/users");
		
		
		System.out.println(response.asString() );
		
		System.out.println(response.getBody().asString() );
		System.out.println(response.getStatusLine());
		
		System.out.println(response.getHeader("content-type") );
		System.out.println(response.getStatusCode() );
		System.out.println(response.getTime());
		//System.out.println(response.body("data.id[1]",equals(8));
	int statuscode=	response.getStatusCode();
		Assert.assertEquals(statuscode,200);
	
	}
	@Test
	void test2() {
		b
		.statusCode(200)
		.log().all();
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		int statuscode=	response.getStatusCode();
		Assert.assertEquals(statuscode,200);
		 if ( statuscode== 200) {

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

		//.body("data.first_name",hasitems("michel","lindsay"));
		
		
		
	}
	
	//@Test
	void test3() {
		given()
		.header("content-type", "application/json")
		.get("http://localhost:3000/users")
		.then()
		.statusCode(200)
	.log().all();
		Response response=RestAssured.get("http://localhost:3000/users");
		int statuscode=	response.getStatusCode();
		Assert.assertEquals(statuscode,200);

		
	}}
	
	
	
	
	
	
	
	
	
/*HashMap  data=new HashMap();
data.put("id","0");
data.put("petId"," 0");
data.put("quantity","0");
 data.put("shipDate", "2022-08-17T06:24:35.730Z");
data.put("status", "placed");*/




	
