package edu.studentapp.cucumber.serenity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.studentapp.model.StudentPOJO;
import edu.studentapp.utilities.ReuseableSpecification;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {
	
	@Step("Create a student with FirstName:{0},LastName:{1},Email:{2},Programme:{3},Courses:{4}")
	public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, List<String> courses)
	{
		StudentPOJO stu = new StudentPOJO();
		stu.setCourses(courses);
		stu.setEmail(email);
		stu.setFirstName(firstName);
		stu.setLastName(lastName);
		stu.setProgramme(programme);
		
		ValidatableResponse validate = SerenityRest.rest()
				.spec(ReuseableSpecification.getGenericRequestSpecification())
		.when().body(stu).post().then();
		
		return validate;
	}
	
	@Step("Get a student information with Email:{0}")
	public HashMap<String, Object> getStudentByEmail(String email1)
	{
		 
		String p1 = "findAll{it.email=='";
		String p2 = "'}.get(0)";
		
		HashMap<String, Object> studentMap = SerenityRest.rest()
				.when().get("/list").then()
				.statusCode(200)
				.extract().path(p1+email1+p2);
		
		
		return studentMap;
	}
	
	@Step("Getting student information with Email:{0}")
	public HashMap<String, Object> getStudentInfoByEmail(String email)
	{
		String p1 = "findAll{it.email=='";
		String p2 = "'}.get(0)";
	
       
		HashMap<String, Object> value = SerenityRest.rest()
				.given()
				.when().get("/list").then()
				.statusCode(200)
				.extract().path(p1+email+p2);
		return value;
	}
	
	
	
	
	@Step("Update student information with FirstName:{0},LastName:{1},Email:{2},Programme:{3},Courses:{4},StudentId:{5}")
	public ValidatableResponse updateStudentByEmail(String firstName1,String lastName1,String email1,String programme1,List<String> courses1,int id)
	{   
		
		
		
		firstName1 = firstName1+"_Update";
		StudentPOJO student = new StudentPOJO();
		student.setCourses(courses1);
		student.setEmail(email1);
		student.setFirstName(firstName1);
		student.setLastName(lastName1);
		student.setProgramme(programme1);
		courses1 = Arrays.asList("C#","Selenium");
		student.setCourses(courses1);
		
		ValidatableResponse valide = SerenityRest.rest().spec(ReuseableSpecification.getGenericRequestSpecification())
		.when().body(student).put("/"+id).then().statusCode(200)
	    .spec(ReuseableSpecification.getGenericResponseSpecification());
		
		return valide;
		
	}
	
	@Step("Delete Student by StudentId:{0}")
	public ValidatableResponse deleteStudentById(int id)
	{
		ValidatableResponse response = SerenityRest.rest().when().delete("/"+id).then();
		
		return response;
	}
	
	@Step("Get Student by StudentId:{0}")
	public ValidatableResponse getStudentById(int id)
	{
		ValidatableResponse response = SerenityRest.rest().when().get("/"+id).then();
		
		return response;
	}
	
	
	
	

}
