package rest_assured_day5;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XmlParseValidation {
	
	@Test(priority=1)
	public void swagger_travel_xml_validate()
	{
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"));
			
	}

}
