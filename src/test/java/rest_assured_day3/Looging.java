package rest_assured_day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Looging {
	
	@Test(priority=1)
	public void log_methods()
	{
		given()
			.when()
				.get("https://reqres.in/api/users/2")
			.then()
				.log().body()
				.log().headers()
				.log().cookies()
				.log().all();
	}

}
