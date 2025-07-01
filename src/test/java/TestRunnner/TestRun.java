package TestRunnner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"Feature"},plugin="json:target/jsonReports/cucumber-report.json",glue={"StepDef"})
//tags="@DeletePlace")
public class TestRun {

}











