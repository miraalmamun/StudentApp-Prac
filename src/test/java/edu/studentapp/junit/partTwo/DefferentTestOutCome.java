package edu.studentapp.junit.partTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class DefferentTestOutCome {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	
	@Title("Get all informations of the students from student App")
	@Test
	public void thisTestPass()
	{
		SerenityRest.rest().when().get("/list").then().statusCode(200);
	}
	
	@WithTag("StudentFeature:POSITIVE")
	@Test
	public void thisTestFail()
	{
		SerenityRest.rest().when().get("/list").then().statusCode(400);
	}
	
	@Test
	public void thisTestError()
	{
		System.out.println(5/0);
	}
	
	@Ignore
	@Test
	public void thisTestSkip()
	{
		System.out.println(5/0);
	}
	
	@Pending
	@Test
	public void thisTestPanding()
	{
		System.out.println(5/0);
	}
	
	@Manual
	@Test()
	public void thisTestRunManually()
	{
		System.out.println("Need to run manually");
	}
	
	
	
	
	
	
	@Test()
	public void thisTestFileNotFoundExcep() throws FileNotFoundException
	{
		File file = new File("");
		FileReader read = new FileReader(file);
		read.toString();
		System.out.println(read);
	}
	
	
	
	
	
	
	

}
