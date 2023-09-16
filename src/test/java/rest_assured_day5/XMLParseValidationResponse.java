package rest_assured_day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLParseValidationResponse {
	
	@Test(priority=1)
	public void swagger_validate_response()
	{
		Response rs =
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		//to validate content type
		String content_type_value = rs.contentType();
		Assert.assertEquals(content_type_value, "application/xml; charset=utf-8");
		int status_code = rs.statusCode();
		Assert.assertEquals(status_code, 200);
		String traveler_name = rs.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[3].name").toString();
		Assert.assertEquals(traveler_name, "Developer123");
		
		
		//to get all the information in form of list
		XmlPath xl = new XmlPath(rs.asString());
		List<String> xml_data = xl.getList("TravelerinformationResponse.travelers");
		//System.out.println(xml_data);
		
		//to know the size of the list
		int size_of_travelers = xml_data.size();
		//System.out.println(size_of_travelers);
		
	}

}
