

package day1;




                                                                                                               

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprvider {
	@DataProvider (name="TaskCreation1")
	public static Object[][] registerData() throws InvalidFormatException, IOException   {
		System.out.println("registerData method");
		

		FileInputStream fis=new FileInputStream("./api documentation.xlsx");
		Workbook	 wb=WorkbookFactory.create(fis);
		
		
		
		Sheet  sheet = wb.getSheet("login");
	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int columnCount= sheet.getRow(0).getPhysicalNumberOfCells();
	    System.out.println(rowCount + "========="+ columnCount);
	    String input[][]=new String[rowCount-1][columnCount];
	    for(int i = 1; i < rowCount; i++) {
	       Row row = sheet.getRow(i);
	      
	     for(int j = 0; j < columnCount; j++) {
	    	 
	    	 
	    	 
	    	 
  Cell cell = row.getCell(j);
	                if(cell != null) {
	                	input[i-1][j] = cell.getStringCellValue();
	                }
	            }
	    }
		System.out.println("getting out from Data Provider registerData");
		return input;
	}

	
	

			

		

	

	
	@Test(dataProvider="TaskCreation1")
	void test3(String emailename,String passwordname) {
	HashMap<String,Object> datab=new HashMap<String,Object>();
	datab.put("email", emailename);
	datab.put("passowrd", passwordname);
	
	System.out.println(datab);
	JSONObject  request= new JSONObject(datab);
	
	System.out.println(request);
	System.out.println(request.toJSONString());
	
	
	given().body(request.toJSONString()).when().post("https://reqres.in/api/login")
	.then().statusCode(200).log().all();
	
	}	
	
	

}
