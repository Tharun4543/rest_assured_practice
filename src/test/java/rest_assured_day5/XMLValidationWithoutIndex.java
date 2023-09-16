package rest_assured_day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;



public class XMLValidationWithoutIndex {
	
	@Test(priority=1)
	public void swagger_validate_without_index()
	{
		Response res =
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		boolean status_value = false;
		XmlPath xobj = new XmlPath(res.asString());
		List<String> traveler_names = xobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		System.out.println(traveler_names);
		for(String value : traveler_names)
		{
			if(value.equals("Tharun"))
			{
				status_value = true;
				break;
			}
		}
		Assert.assertEquals(status_value, true);
		
	}

}
