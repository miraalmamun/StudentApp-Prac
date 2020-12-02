package edu.studentapp.junit.StudentCRUD;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.studentapp.cucumber.serenity.StudentSerenitySteps;
import edu.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("testData\\StudentData.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest extends TestBase {
	
	@Steps
	StudentSerenitySteps steps;
	
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private String courses;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public StudentSerenitySteps getSteps() {
		return steps;
	}

	public void setSteps(StudentSerenitySteps steps) {
		this.steps = steps;
	}


	
	
	
	@Title("Create multiples student and to the Student App.")
	@Test
	public void createMultiplesStuden()
	{
		ArrayList<String> courses2 = new ArrayList<String>();
		courses2.add(courses);
		steps.createStudent(firstName, lastName, email, programme, courses2);
	}
	

}
