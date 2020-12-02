package edu.studentapp.cucumber.grouping;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;


@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
	
	
	@WithTags({@WithTag("studentfeature:NEGETIVE"),
		@WithTag("StudentFeature:SMOKE")})
	@Test
	@Title("Response status code 405 if user provides incorrect HTTP method to access a resource")
	public void incorrectHTTPMethod()
	{
		SerenityRest.rest().given().when().post("/list").then().statusCode(405);
	}
   
	@WithTags({@WithTag("studentfeature:NEGETIVE"),
		@WithTag("StudentFeature:SMOKE")})
	@Test
	@Title("Response status code 405 if user provides incorrect HTTP method to access a resource")
	public void incorrectHTTPMethod2()
	{
		Response response = SerenityRest.rest().given().when().post("/list").then()
		.assertThat().extract().response();
		
		if(response.getStatusCode()==405)
		{
			System.out.println("Hello I am 405");
		}
	}
	
	@WithTags({@WithTag("StudentFeature:POSITIVE"),
		@WithTag("StudentFeature:REGRESSION")})
	@Title("Varify the status code 200 if the user use GET method on a right resource")
	@Test
	public void varifyIfTheStatusCodeIs200()
	{
		SerenityRest.rest().given().when().get("/list").then().statusCode(200);
	}
	
	
	@WithTags({@WithTag("studentfeature:NEGETIVE"),
		@WithTag("StudentFeature:REGRESSION")})
	@Title("Status code should be 400 if the user tries to accesss an incorrect resource")
	@Test
	public void incorrectResource()
	{
		SerenityRest.rest().given().when()
		.get("/listxyz").then().statusCode(400);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
