package rest_assured_day4;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParseValidationRes {
	
	@Test(priority=1)
	public void reqrs_validate_res()
	{
		Response rs = given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("https://reqres.in/api/unknown/2");
		
		String name = rs.jsonPath().get("data.name").toString();
		String color = rs.jsonPath().getString("data.color").toString();
		String support_url = rs.jsonPath().getString("support.url").toString();
		
		Assert.assertEquals(name, "fuchsia rose");
		Assert.assertEquals(color, "#C74375");
		Assert.assertEquals(support_url, "https://reqres.in/#support-heading");
	}

}
