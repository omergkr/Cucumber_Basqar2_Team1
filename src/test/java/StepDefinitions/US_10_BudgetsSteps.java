package StepDefinitions;

import Pages.Budgets_Content;
import Pages.PositionCategories_Content;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_10_BudgetsSteps {

    Budgets_Content budgetsContent = new Budgets_Content();


    @When("^Click on the element in the Budgets content class$")
    public void clickOnTheElementInTheBudgetsContentClass(DataTable elements) {

        List<String> elementsToClick = elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            System.out.println(elementsToClick.get(i));
            budgetsContent.findAndClickElement(elementsToClick.get(i));

        }
    }


    @Then("^User sending the keys in the Budgets content class$")
    public void userSendingTheKeysInTheBudgetsContentClass(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {

            System.out.println(elementsNameAndValue.get(i).get(0)); // elemanın adı
            System.out.println(elementsNameAndValue.get(i).get(1)); // elemanın gönderilecek değeri

            budgetsContent.findElementAndSendKeys(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }
    }


    @Then("^Success Message should be Displayed$")
    public void successMessageShouldBeDisplayed() {

        budgetsContent.findElementAndVerifyContainsText("message","successfully");

    }


    @And("^User delete the Budgets \"([^\"]*)\"$")
    public void userDeleteTheBudgets(String nameOfBudgetsToDelete)  {

        budgetsContent.editAndDeleteFunction(nameOfBudgetsToDelete,"delete");
        budgetsContent.findAndClickElement("yesButton");
    }



    @Then("^Error Message should be Displayed$")
    public void errorMessageShouldBeDisplayed() {

        budgetsContent.elementisEnabled("saveButton");

    }

}