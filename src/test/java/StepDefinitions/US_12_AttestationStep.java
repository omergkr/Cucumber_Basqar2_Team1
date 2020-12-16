package StepDefinitions;

import Pages.Attestations_Content;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;


public class US_12_AttestationStep {

    Attestations_Content attestations_content = new Attestations_Content();


    @Then("^Navigate to  Attestation  page$")
    public void navigateToAttestationPage() {

        attestations_content.findAndClickElement("humanBtn");
        attestations_content.findAndClickElement("SetupBtn");
        attestations_content.findAndClickElement("attestationBtn");


    }

    @Then("^click on button with button name Attestation$")
    public void clickOnButtonWithButtonNameAttestation(DataTable elements) {

        List<String> elementsToClick = elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            System.out.println(elementsToClick.get(i));
            attestations_content.findAndClickElement(elementsToClick.get(i));
        }

    }


    @Then("^Success message should be displayed attestation$")
    public void successMessageShouldBeDisplayedAttestation() {
        attestations_content.findElementAndVerifyContainsText("msjContainer", "successfully");
    }

    @When("^User Edit Attestation the \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditAttestationTheTo(String attetiName, String NewName) {
        attestations_content.editAndDeleteFunction(attetiName, "edit");
        attestations_content.findElementAndSendKeys("nameInput", NewName);
        attestations_content.findAndClickElement("saveButton");
    }


    @When("^searching by Attestation name as \"([^\"]*)\"$")
    public void searchingByAttestationNameAs(String AttName) {
        attestations_content.findElementAndSendKeys("searchName", AttName);
        attestations_content.findAndClickElement("searchButton");
    }


    @When("^The user should delete the Attestation in the name \"([^\"]*)\"$")
    public void theUserShouldDeleteTheAttestationInTheName(String AttesNameDelete) {
        attestations_content.editAndDeleteFunction(AttesNameDelete, "delete");
        attestations_content.findAndClickElement("yesButton");
    }

    @When("^page validation Attestations$")
    public void pageValidationAttestations() {

        attestations_content.findElementAndVerifyContainsText("AttestationsPageTitle", "Attestations");
    }


    @When("^Create a new Attestations name as \"([^\"]*)\"$")
    public void createANewAttestationsNameAs(String name) {
        attestations_content.findAndClickElement("addBtn");

        attestations_content.findElementAndSendKeys("nameInput", name);

        attestations_content.findAndClickElement("saveButton");

    }
}

