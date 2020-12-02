package edu.studentapp.junit.partOne;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class FirstSerenityTest {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Test
	public void getAllStudents()
	{
		RestAssured.given().when().get("/list").then().log().all().statusCode(200);
	}

}
