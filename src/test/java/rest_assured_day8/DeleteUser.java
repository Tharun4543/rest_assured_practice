package rest_assured_day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class DeleteUser {
	
	@Test
	public void delete_user(ITestContext context)
	{
		int id = (Integer) context.getSuite().getAttribute("user_id");
		String bearear_token = "3253de577e6ff28bad2d004b259df62bfe4f4d92b243dd81d8abc3fbeecadcef";
		given()
		.headers("Authorization", "Bearer "+bearear_token)
		.contentType("application/json")
		.pathParam("user_id", id)
		
		.when()
			.delete("https://gorest.co.in/public/v2/users/{user_id}")
		.then()
			.statusCode(204)
			.log().all();
	}

}
