package StepDefinitions;

import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _Hooks {
    @Before
    public void before(Scenario scenario)
    {
        System.out.println("Scenario started");
        System.out.println("Scenario Id : " + scenario.getId());
        System.out.println("Scenario Name : " +scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Scenario finished");
        System.out.println("The result of the Scenario : " + scenario.getStatus());

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
        String strDate = formatter.format(now);
        System.out.println(strDate);

        if (scenario.getStatus() == "failed") {
            String scenarioName = scenario.getName();

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(ekranDosyasi, new File("target/FailedScreenShots/" +
                        Driver.threadBrowserName.get() + scenarioName + strDate + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

     Driver.quitDriver();
    }

}
