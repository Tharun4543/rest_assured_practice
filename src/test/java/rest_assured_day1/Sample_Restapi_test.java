package rest_assured_day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Random;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
public class Sample_Restapi_test 
{
	String id,name;
	//Fetch all the details using get request 
	@Test(priority=1)
	public void reqrs_get_rest_api_test()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();		
	}
	//create the data using post request
	@Test(priority=2)
	public void reqrs_post_rest_api_test()
	{
		String response =given()
			.contentType("application/json")
			.body(bodyData())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.extract()
			.response()
			.asString();
		
		JsonPath jp = new JsonPath(response);
		id = jp.getString("id");
		name = jp.getString("name");
	}
	//update the record using put request
	@Test(priority=3)
	public void reqrs_update_rest_api_test()
	{
		
		
		
			given()
				.contentType("application/json")
				.body(bodyData())
			.when()
				.put("https://reqres.in/api/users/" + id)
			.then()
				.statusCode(200);
					
	}
	//delete the record using delete request
	@Test(priority=4)
	public void reqrs_delete_rest_api_test()
	{
	when()
		.delete("https://reqres.in/api/users/" + id)
	.then()
		.statusCode(204);
	}
	
	public HashMap bodyData()
	{
		Sample_Restapi_test sp = new Sample_Restapi_test();
		HashMap<String,String> hp=new HashMap<String, String>();
		hp.put("name",sp.set_username());
		hp.put("job",sp.set_job_data());
		return hp;
	}
				
	public String set_job_data()
	{
		String job_values[] = {"Software Developer", "Software Tester", "Accoutant", "Director", "Actor", "Professor"};
		Random random = new Random();
        int randomIndex = random.nextInt(job_values.length);
        String randomColor = job_values[randomIndex];
        return randomColor;
	}
	public String set_username()
	{
		StringBuilder randomStringBuilder = new StringBuilder();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int length = 8;
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomStringBuilder.append(randomChar);
        }
        return randomStringBuilder.toString();
	     
	}
	
	
}
