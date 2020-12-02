package edu.studentapp.junit.StudentCRUD;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import edu.studentapp.cucumber.serenity.StudentSerenitySteps;
import edu.studentapp.testbase.TestBase;
import edu.studentapp.utilities.GetRandomNumber;
import edu.studentapp.utilities.ReuseableSpecification;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class StudentCRUDTest2 extends TestBase {
	
	static String firstName1 = GetRandomNumber.getRandomString()+"Mir";
	static String lastName1 = "Al Mamun"+GetRandomNumber.getRandomString();
	static String email1 = GetRandomNumber.getRandomString()+"abc@gmail.com";
	static String programme1 = "Manager";
	static int studentId;
	
	
	@Steps
	StudentSerenitySteps steps;
	
	
	@Title("Create a student with all mandatory fields in the student database")
	@Test
	public void test001()
	{
		List<String> courses1 = Arrays.asList("Java","Selenium");
		
		steps.createStudent(firstName1, lastName1, email1, programme1, courses1).statusCode(201)
		.spec(ReuseableSpecification.getGenericResponseSpecification());
		
	}
	

	@Title("Scan all students from student database and varify that the student is added")
	@Test
	public void test002() {
		
		
        HashMap<String,Object> value = steps.getStudentInfoByEmail(email1);
		     
        studentId= (int)value.get("id");
		
		assertThat(value, hasValue(email1));

	}
	
	
	
    
	@Title("Update student informations and verify that informations are updated")
	@Test
	public void test003()
	{   
		
		List<String> courses = Arrays.asList("Java","Selenium");
		
		steps.createStudent(firstName1, lastName1, email1, programme1, courses);
		
		 email1 = "Update_"+email1;
		 
		steps.updateStudentByEmail(firstName1, lastName1, email1, programme1, courses, studentId);
		
		
		HashMap<String, Object> value = steps.getStudentByEmail(email1);
		
		
		assertThat(value, hasValue(email1));
		
		
	}
	
	
	@Title("Delete student information and varify student is deleted")
	@Test
	public void test004()
	{
		Response res = steps.deleteStudentById(studentId).assertThat().extract().response();
		
		//Detete something status code 204 and Empty resource also 204 status code
		System.out.println("Status code: "+res.getStatusCode());
        
		//No resource found status code 404
		steps.getStudentById(studentId).statusCode(404);
		
		
	}
	
	
	
}






