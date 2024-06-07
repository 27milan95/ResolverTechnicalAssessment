package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinition"},
        plugin = {"pretty", "html:test-outout/testoutputs.html"},
        monochrome = true, 
			dryRun = false 
			//tags = "@smoke"
)
public class TestRunner {

}
