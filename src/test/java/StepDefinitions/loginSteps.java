package StepDefinitions;

import Pages.DialogContent;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class loginSteps {


    WebDriver driver;

    @Given("^Navigate to basqar$")
    public void navigateToBasqar() {

        driver = Driver.getDriver();
        driver.get("https://test.basqar.techno.study/");
        driver.manage().window().setSize(new Dimension(1920,1080));

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @When("^Enter username and password and click Login button$")
    public void enterUsernameAndPasswordAndClickLoginButton() {

        DialogContent dialogContent = new DialogContent();
        dialogContent.findElementAndSendKeys("username","daulet2030@gmail.com");
        dialogContent.findElementAndSendKeys("password","TechnoStudy123@");
        dialogContent.findAndClickElement("loginButton");
        dialogContent.findAndClickElement("gotItBtn");



    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {







    }
}
