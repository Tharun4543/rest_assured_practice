package rest_assured_day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BodyCreation_Pojo {
	
	PojoVariablesandMethods pj;
	
	
	@Test(priority=1)
	public void reqrs_post_pojo()
	{
		pj= new PojoVariablesandMethods();
		pj.setName("Dilraju");
		pj.setJob("Producer");
		given()
		.contentType("application/json")
		.body(pj)
	
		.when()
	    	.post("https://reqres.in/api/users")
	    .then()
			.statusCode(201)
			.body("name", equalTo("Dilraju"))
			.body("job", equalTo("Producer"))
			.log().all();
	}

}
