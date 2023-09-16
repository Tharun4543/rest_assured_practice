package rest_assured_day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersValidation {

	@Test(priority=1)
	public void header_validate()
	{
		Response rs = given()
			.when()
				.get("https://www.facebook.com/");
		
		//getting header value
		String content_type_value = rs.getHeader("Content-Type");
		System.out.println(content_type_value);
		
		//getting all header values
		
		Headers cookies_hd =rs.getHeaders();
		for(Header cookie_value : cookies_hd)
		{
			System.out.println(cookie_value.getName() + ":" + cookie_value.getValue());
		}
	}
}
