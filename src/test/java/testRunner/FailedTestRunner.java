package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt", glue = "step_definitions", stepNotifications = true, plugin = {
		"pretty", "html:reports/myreport.html", "json:reports/myreport.json", "rerun:target/rerun.txt",

}, dryRun = true, monochrome = true, tags = "@buildfromscratch"

)

public class FailedTestRunner {

}
