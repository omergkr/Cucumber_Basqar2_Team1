package StepDefinitions;

import Pages.DialogContentBudgetProject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class US_09_BudgetProjectsPageFunctionalitySteps {

    WebDriver driver;
    DialogContentBudgetProject dContent =new DialogContentBudgetProject();


    @When("^User click on the element$")
    public void userClickOnTheElement(DataTable elements) {

        List<String> elementsToClick=elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            dContent.findElementAndClickFunction(elementsToClick.get(i));

        }

    }

    @Then("^Send value to element's inputbox$")
    public void sendValueToElementSInputbox(DataTable elements) {

        List<List<String>> elementsNameAndValue=elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            dContent.findElementAndSendKeysFunction(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }

    }


    @Then("^User should see Budget Projects page correctly$")
    public void userShouldSeeBudgetProjectsPageCorrectly(){

    String myText="Budget Projects";


        dContent.verifyElementContainsText(dContent.titleBudgetProjects, myText);

    }



    @Then("^User should see \"([^\"]*)\" message$")
    public void userShouldSeeMessage(String alert) {

        dContent.findElementAndFindVerifyContainsText(alert, "success");
    }

    @And("^User delete the \"([^\"]*)\"$")
    public void userDeleteThe(String value) {

        dContent.deleteFunction(value);
        //dContent.findElementAndClickFunction("yesButton");

    }

    @Then("^check the button as name of \"([^\"]*)\", should be inactive$")
    public void checkTheButtonAsNameOfShouldBeInactive(String elementname) {

        dContent.checkElementActive(elementname);

    }


}
