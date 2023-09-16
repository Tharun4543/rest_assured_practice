package rest_assured_day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryandPathParameters {
	
	@Test(priority=1)
	public void reqrs_queryandpath()
	{
		given()
			.pathParam("users_path", "users")
			.queryParam("delay", 3)
		.when()
			.get("https://reqres.in/api/{users_path}")
		.then()
			.log().body();
	}

}
