package rest_assured_day4;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class ParseValidationIndex {
	
	@Test(priority=1)
	public void reqrs_validate_data()
	{
		given()
			.when()
				.get("https://reqres.in/api/unknown/2")
			.then()
				.statusCode(200)
				.log().body();
	}
}
