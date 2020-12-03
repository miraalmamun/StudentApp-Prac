package edu.studentapp.cucumber.steps;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import edu.studentapp.cucumber.serenity.StudentSerenitySteps;
import edu.studentapp.utilities.GetRandomNumber;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.*;

public class StudentSteps {
	
	public static String email = null;
	@Steps
	StudentSerenitySteps steps;
	
	@Given("^User sends a GET request to the list endpoint, they must get back a valid status code 200$")
	public void getStatusCodeForListEndpoint()
	{
		SerenityRest.rest()
		.given().when().get("/list")
		.then().statusCode(200);
	}
	
	@Given("^User create a student by providing the information firstName (.*) lastName (.*) email (.*) programme (.*) courses (.*)$")
	public void createAStudent(String firstName,String lastName,String _email,String programme,String courses) {
	   
		ArrayList<String> course = new ArrayList<String>();
		course.add(courses);
		
		email = GetRandomNumber.getRandomString()+_email;
		
		steps.createStudent(firstName, lastName, email, programme, course)
		.assertThat().statusCode(201);
	}

	@Then("^User varify that the student with (.*) is created$")
	public void varifyStudentAdded(String emailId)  {
		
		HashMap<String, Object > value = steps.getStudentByEmail(email);
		
		assertThat(value, hasValue(email));
		
	  
	}

}
