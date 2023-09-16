package rest_assured_day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class CreateUser {
	
	@Test
	public void create_user(ITestContext context)
	{
		JSONObject jo = new JSONObject();
		Faker fk = new Faker();
		jo.put("name", fk.name().fullName());
		jo.put("email", fk.internet().emailAddress());
		jo.put("gender", "male");
		jo.put("status", "active");
		String bearear_token = "3253de577e6ff28bad2d004b259df62bfe4f4d92b243dd81d8abc3fbeecadcef";
		Response rs = given()
			.headers("Authorization", "Bearer "+bearear_token)
			.contentType("application/json")
			.body(jo.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users");
			
		String gorest_id = rs.jsonPath().get("id").toString();
		int id = Integer.parseInt(gorest_id);
	
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
		//System.out.println(id);
		
	}
	
	

}
