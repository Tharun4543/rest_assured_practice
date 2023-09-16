package rest_assured_day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParseValidationWithoutIndex {
	
	@Test(priority=1)
	public void reqrs_validation_without_index()
	{
		Response rs = given()
						.contentType(ContentType.JSON)
					  .when()
					  	.get("https://reqres.in/api/users?page=2");
		
		JSONObject js = new JSONObject(rs.asString());
		boolean flag = false;
		for(int i=0; i<js.getJSONArray("data").length(); i++)
		{
			String first_name_person = js.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			if(first_name_person.equals("Georg"))
			{
				flag = true;
				Assert.assertEquals(flag, true);
			}
			
		}
		if(flag==false)
		{
			Assert.fail();
		}
		
	}

}
