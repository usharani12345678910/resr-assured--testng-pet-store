package day1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadriven {
	@Test(dataProvider="user deatails     ")
	void test3(String name,String job,String age) {
	
	
	JSONObject  request= new JSONObject();
	request.put("name", name);
	request.put("job", job);
	request.put("age", age);
	System.out.println(request);
	System.out.println(request.toJSONString());
	
	
	given().body(request.toJSONString()).when().post("http://localhost:3000/users")
	.then().statusCode(201).log().all();

	
	
	
}
	@DataProvider(name="user deatails")
	public Object[][] dataforpost(){
		/*
		 * Object[][] data=new Object[2][3];
		 * 
		 * 
		 * //Assign Value to First Row
		 *  data[0][0]="albert";
		 *   data[0][1]="ediston";
		 * data[0][2]="2";
		 * 
		 * //Assign Value to Second Row 
		 * data[1][0]="robert"; 
		 * data[1][1]="robert2";
		 * data[1][2]="3";
		 * return data;
		 */
return new Object[][] {
	{"graham ","bell","1"},
	{"henery","potry","2"}
};
	      
		
		
		
	}
}
