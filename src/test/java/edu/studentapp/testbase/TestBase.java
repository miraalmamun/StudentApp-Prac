package edu.studentapp.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
	
	
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080/student";
		
		//SerenityRest.get("http://localhost:8080/student");
	}

}
