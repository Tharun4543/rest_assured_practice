package rest_assured_day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class CookiesValidation {
	
	@Test(priority=1)
	public void facebook_cookies()
	{
		Response rs=given()
			.when()
				.get("https://www.facebook.com/");
		
		//get single cookie value
		String cookie_value = rs.getCookie("fr");
		System.out.println("The cookie value is  ==>  " + cookie_value);
		
		//get all cookies value
		Map<String,String> cookie_data = rs.getCookies();
		for(String value:cookie_data.keySet())
		{
			System.out.println(value + ":" + rs.getCookie(value));
		}
	}
}
