package StepDefinitions;

import Pages.Fees_Content;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class US_03_FeesSteps {

    Fees_Content feesContent = new Fees_Content();





    @Then("^Navigate to Fee page$")
    public void navigateToFeePage() {

        feesContent.findAndClickElement("SetupBtn");
        feesContent.findAndClickElement("ParametersBtn");
        feesContent.findAndClickElement("feeBtn");
    }

    @When("^Create a new Fees$")
    public void createANewFees() {

        feesContent.findAndClickElement("addBtn");
        feesContent.findElementAndSendKeys("nameInput","Talha");
        feesContent.findElementAndSendKeys("codeInput","2019");
        feesContent.findElementAndSendKeys("integrationCode","63");
        feesContent.findElementAndSendKeys("priorityCode","1907");
        feesContent.findAndClickElement("saveButton");

    }

    @When("^User Edit Fees the \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditFeesTheTo(String feeName, String feeNewName) {
        feesContent.editAndDeleteFunction(feeName, "edit");
        feesContent.findElementAndSendKeys("nameInput",feeNewName);
        feesContent.findElementAndSendKeys("codeInput","2015");
        feesContent.findElementAndSendKeys("integrationCode","6346");
        feesContent.findElementAndSendKeys("priorityCode","111");
        feesContent.findAndClickElement("saveButton");

    }

    @When("^The user should delete the fees in the name \"([^\"]*)\"$")
    public void theUserShouldDeleteTheFeesInTheName(String feeNameDelete) {
        feesContent.editAndDeleteFunction(feeNameDelete, "delete");
        feesContent.findAndClickElement("yesButton");


    }

    @When("^searching by Fees name as \"([^\"]*)\"$")
    public void searchingByFeesNameAs(String feeName) {

        feesContent.findElementAndSendKeys("searchFeeName",feeName);
feesContent.findAndClickElement("searchButton");
    }
}
