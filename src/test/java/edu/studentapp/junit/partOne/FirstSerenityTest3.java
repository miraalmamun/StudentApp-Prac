package edu.studentapp.junit.partOne;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest3 {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Test
	public void getAllStudents3()
	{
		//SerenityRest.rest().when().get("/list").then().log().all().statusCode(200);
		SerenityRest.rest().when().get("/list").then().statusCode(200);
	}

}
