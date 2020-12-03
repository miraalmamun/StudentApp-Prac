package edu.studentapp.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import edu.studentapp.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/student.feature")
public class StudentRunner extends TestBase{

}
