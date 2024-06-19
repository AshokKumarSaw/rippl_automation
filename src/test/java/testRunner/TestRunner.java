package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ("src/test/java/feature_files"),
//features="@target/rerun.txt",   // Runs only failures
glue = "step_definitions", 
stepNotifications = true, 
plugin = {
		"pretty", "html:reports/myreport.html", "json:reports/myreport.json", "rerun:target/rerun.txt", // Mandatory to
																										// capture																										// failures
}, 
dryRun = true, 
monochrome = true, 
tags = "@buildfromscratch"

)
public class TestRunner {

}
