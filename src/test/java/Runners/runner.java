package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        tags ={"@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false,
        plugin = {"html:target/cucumber-report","json:target/cucumber.json"}
)
public class runner extends AbstractTestNGCucumberTests {




}
