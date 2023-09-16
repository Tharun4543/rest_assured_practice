package rest_assured_day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class BodyCreation_ExternalFile {
	
	@Test(priority=1)
	public void reqrs_jsonfile() throws FileNotFoundException
	{
		File fp = new File(".\\reqrs_body.json");
		FileInputStream fis = new FileInputStream(fp);
		JSONTokener jt = new JSONTokener(fis);
		JSONObject jo = new JSONObject(jt);
		
		given()
		.contentType("application/json")
		.body(jo.toString())
	
		.when()
	    	.post("https://reqres.in/api/users")
	    .then()
			.statusCode(201)
			.body("name", equalTo("Sai Pallavi"))
			.body("job", equalTo("Actress"))
			.log().all();
	}
	
}
