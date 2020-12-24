package Runners;

import Utilities.Driver;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@CucumberOptions(

        tags = { "@SmokeTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false,
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportSmokeTest.html"
        }




)


public class SmokeTest_Parallel extends AbstractTestNGCucumberTests {


    @BeforeClass
    @Parameters("browser")
    public static void beforeClass(String browser){


            Driver.threadBrowserName.set(browser);

    }



        @AfterClass
    public static void afterClass(){


            Reporter.loadXMLConfig("src/test/java/XMLFiles/extentReportSet.xml");
            Reporter.setSystemInfo("User Name","Team 1");
            Reporter.setSystemInfo("Application Name","Basqar");
            Reporter.setSystemInfo("Application Name","Basqar");
            Reporter.setSystemInfo("Operating System Info",System.getProperty("os.name"));
            Reporter.setSystemInfo("Department","QA");
            Reporter.setTestRunnerOutput("Test execution Cucumber report");





    }








}
