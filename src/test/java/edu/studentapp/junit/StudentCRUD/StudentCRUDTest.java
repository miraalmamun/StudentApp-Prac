package edu.studentapp.junit.StudentCRUD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import edu.studentapp.model.StudentPOJO;
import edu.studentapp.testbase.TestBase;
import edu.studentapp.utilities.GetRandomNumber;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class StudentCRUDTest extends TestBase {
	
	static String firstName1 = GetRandomNumber.getRandomString()+"Mir";
	static String lastName1 = "Al Mamun"+GetRandomNumber.getRandomString();
	static String email1 = GetRandomNumber.getRandomString()+"abc@gmail.com";
	static String programme1 = "Manager";
	static List<String> courses1;
	static int id;
	StudentPOJO student;
	
	
	
	
	@Title("Create a student with all mandatory fields in the student database")
	@Test
	public void test001()
	{
		student = new StudentPOJO();
		student.setFirstName(firstName1);
		student.setLastName(lastName1);
		student.setEmail(email1);
		student.setProgramme(programme1);
		courses1 = Arrays.asList("Java","Selenium");
		student.setCourses(courses1);
		
		SerenityRest.rest().header("Content-Type","application/json; charset=UTF-8")
		.when().body(student).post().then().log().all().statusCode(201).body("msg",equalTo("Student added"));
	}
	
	
	@Title("Get all students from student database and varify that added student exist in database")
	@Test
	public void test002()
	{   
		String p1 = "findAll{it.email=='";
		String p2 = "'}.get(0)";
		
		HashMap<String, Object> studentMap = SerenityRest.rest().when()
		.get("/list").then().log().all().statusCode(200).extract().response().path(p1+email1+p2);
		System.out.println(studentMap);
		
		id = (int) studentMap.get("id");
		/*
		Collection<Object> obj = studentMap.values();
		Iterator<Object> itr = obj.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		*/
		assertThat(studentMap, hasValue(email1));
		assertThat(studentMap, hasValue(firstName1));
		assertThat(studentMap, hasValue(lastName1));
		assertThat(studentMap, hasValue(programme1));
		assertThat(studentMap, hasValue(courses1));
	}
    
	@Title("Update student informations and verify that informations are updated")
	@Test
	public void test003()
	{   
		String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		
		firstName1 = firstName1+"_Update";
		student = new StudentPOJO();
		student.setCourses(courses1);
		student.setEmail(email1);
		student.setFirstName(firstName1);
		student.setLastName(lastName1);
		student.setProgramme(programme1);
		courses1 = Arrays.asList("C#","Selenium");
		student.setCourses(courses1);
		
		SerenityRest.rest().contentType(ContentType.JSON)
		.when().body(student).put("/"+id).then().statusCode(200)
		.log().all();
		
		HashMap<String, Object> studentMap = SerenityRest.rest()
		.when().get("/list").then().statusCode(200)
		.extract().path(p1+firstName1+p2);

		assertThat(studentMap, hasValue(firstName1));
	}
	
	@Title("Delete student information and varify student is deleted")
	@Test
	public void test004()
	{
		int stco = SerenityRest.rest().when().delete("/"+id).getStatusCode();
		System.out.println(stco);
		
		SerenityRest.rest().when().get("/"+id).then().statusCode(404);
		
		
	}
	
	
	
}






