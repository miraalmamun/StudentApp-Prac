package edu.studentapp.utilities;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;;

public class ReuseableSpecification {

	public static RequestSpecification reqSpec;
	public static ResponseSpecification resSpec;
	public static RequestSpecBuilder reqSpecBuild;
	public static ResponseSpecBuilder resSpecBuild;

	public static RequestSpecification getGenericRequestSpecification() {
		reqSpecBuild = new RequestSpecBuilder();
		reqSpecBuild.setContentType(ContentType.JSON);
		reqSpec = reqSpecBuild.build();
		return reqSpec;
	}

	public static ResponseSpecification getGenericResponseSpecification() {
		resSpecBuild = new ResponseSpecBuilder();
		resSpecBuild.expectHeader("Content-Type", "application/json;charset=UTF-8");
		resSpecBuild.expectHeader("Transfer-Encoding", "chunked");
		resSpecBuild.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		resSpec = resSpecBuild.build();
		return resSpec;
	}
	
	/*
	public static ResponseSpecification getGenericResponseSpecification()
	{  
		respecb = new ResponseSpecBuilder();
		respecb.expectHeader("Content-Type", "application/json;charset=UTF-8");
		respecb.expectHeader("Transfer-Encoding", "chunked");
		respecb.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		respec = respecb.build();
		return respec;
    }
   */
}
