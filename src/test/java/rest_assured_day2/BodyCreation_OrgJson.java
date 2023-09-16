package rest_assured_day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BodyCreation_OrgJson {
	
	
	JSONObject jos = new JSONObject();
	@Test(priority=1)
	public void reqrs_post_orgjson()
	{
		jos.put("name", "Vijay Sethupathi");
		jos.put("job", "Actor");
		
		given()
			.contentType("application/json")
			.body(jos.toString())
		
		.when()
		    .post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.body("name", equalTo("Vijay Sethupathi"))
			.body("job", equalTo("Actor"));
	}

}
