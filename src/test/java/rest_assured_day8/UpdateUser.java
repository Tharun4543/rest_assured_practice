package rest_assured_day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	public void update_user(ITestContext context)
	{
		int id = (Integer) context.getSuite().getAttribute("user_id");
		JSONObject jo = new JSONObject();
		Faker fk = new Faker();
		jo.put("name", fk.name().fullName());
		jo.put("email", fk.internet().emailAddress());
		jo.put("gender", "male");
		jo.put("status", "inactive");
		String bearear_token = "3253de577e6ff28bad2d004b259df62bfe4f4d92b243dd81d8abc3fbeecadcef";
		given()
			.headers("Authorization", "Bearer "+bearear_token)
			.contentType("application/json")
			.body(jo.toString())
			.pathParam("user_id", id)
		.when()
			.put("https://gorest.co.in/public/v2/users/{user_id}")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
}
