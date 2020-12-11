package StepDefinitions;

import Pages.FeeContent;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class US_03_FeeStep {

    FeeContent feeContent = new FeeContent();





    @Then("^Navigate to Fee page$")
    public void navigateToFeePage() {

        feeContent.findAndClickElement("SetupBtn");
        feeContent.findAndClickElement("ParametersBtn");
        feeContent.findAndClickElement("feeBtn");
    }

    @When("^Create a new Fees$")
    public void createANewFees() {

        feeContent.findAndClickElement("addBtn");
        feeContent.findElementAndSendKeys("nameInput","Talha");
        feeContent.findElementAndSendKeys("codeInput","2019");
        feeContent.findElementAndSendKeys("integrationCode","63");
        feeContent.findElementAndSendKeys("priorityCode","1907");
        feeContent.findAndClickElement("saveButton");

    }

    @When("^User Edit Fees the \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditFeesTheTo(String feeName, String feeNewName) {
        feeContent.editAndDeleteFunction(feeName, "edit");
        feeContent.findElementAndSendKeys("nameInput",feeNewName);
        feeContent.findElementAndSendKeys("codeInput","2015");
        feeContent.findElementAndSendKeys("integrationCode","6346");
        feeContent.findElementAndSendKeys("priorityCode","111");
        feeContent.findAndClickElement("saveButton");

    }

    @When("^The user should delete the fees in the name \"([^\"]*)\"$")
    public void theUserShouldDeleteTheFeesInTheName(String feeNameDelete) {
        feeContent.editAndDeleteFunction(feeNameDelete, "delete");
        feeContent.findAndClickElement("yesButton");


    }

    @When("^searching by Fees name as \"([^\"]*)\"$")
    public void searchingByFeesNameAs(String feeName) {

        feeContent.findElementAndSendKeys("searchFeeName",feeName);
feeContent.findAndClickElement("searchButton");
    }
}
