package edu.studentapp.junit.partOne;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest2 {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Title("This test will get the information of the all students the students app ")
	@Test
	public void getAllStudents2()
	{
		//RestAssured.given().when().get("/list").then().log().all().statusCode(200);
		RestAssured.given().when().get("/list").then().statusCode(200);
	}

}
