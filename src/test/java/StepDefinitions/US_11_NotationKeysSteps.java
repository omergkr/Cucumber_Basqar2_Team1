package StepDefinitions;

import Pages.DialogContent;
import Pages.NotationKeys_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_11_NotationKeysSteps {

    NotationKeys_Content mainContent=new NotationKeys_Content();
    DialogContent dialogContent=new DialogContent();


    @Given("^Navigate to Notation Keys page$")
    public void navigateToNotationKeysPage() {
        mainContent.findAndClickElement("HumanResourcesButton");
        mainContent.findAndClickElement("NotationSetupButton");
        mainContent.findAndClickElement("NotationKeysButton");
        //mainContent.findElementAndVerifyContainsText("NotationKeysTittle","  Timesheet Notation Keys ");
    }

    @Then("^Notation Keys title control$")
    public void notationKeysTitleControl() {
        mainContent.findElementAndVerifyContainsText("NotationKeysTittle","Timesheet Notation Keys");
    }





    @When("^Click on Buttons  of Notation Page$")
    public void clickOnButtonsOfNotationPage(DataTable elements) {
        List<String> elementstoClick = elements.asList(String.class);
        for (String n : elementstoClick) {
            System.out.println(n);
            mainContent.findAndClickElement(n);
        }
    }

    @Then("^Send text in  NotationInputNameBox$")
    public void sendTextInNotationInputNameBox(DataTable elements) {
        List<List<String>>  elementsNameAndValue=elements.asLists(String.class);

        for (int i = 0; i <elementsNameAndValue.size() ; i++) {

            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
            mainContent.findElementAndSendKeys(elementsNameAndValue.get(i).get(0),elementsNameAndValue.get(i).get(1));

        }

    }


    @Then("^Send text in   Input Boxes of Notation Page$")
    public void sendTextInInputBoxesOfNotationPage(DataTable elements) {
        List<List<String>> elementsNameAndValue=elements.asLists(String.class);
        for (int i = 0; i <elementsNameAndValue.size() ; i++) {
            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
            mainContent.findElementAndSendKeys(elementsNameAndValue.get(i).get(0),elementsNameAndValue.get(i).get(1));

        }
    }


    @Then("^Success message should be displayed for Notation Key$")
    public void successMessageShouldBeDisplayedForNotationKey() {
        mainContent.findElementAndVerifyContainsText("NotationKeyCreatedSuccessfullyMessage","Notation Key successfully created");
    }

    @Then("^Check to List of Notation Keys with  Name or Shortname$")
    public void checkToListOfNotationKeysWithNameOrShortname(DataTable elements) {
        List<List<String>> elementsNameAndValue=elements.asLists(String.class);
        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
            mainContent.CheckNotationKeysListWithName(elementsNameAndValue.get(i).get(0),elementsNameAndValue.get(i).get(1));

        }

    }

    @When("^User can Notation Keys edit the name  \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userCanNotationKeysEditTheNameTo(String documentTypesName, String newDocumentTypesName)  {
        dialogContent.editAndDeleteFunction(documentTypesName,"edit");

        mainContent.findElementAndSendKeys("forEditNameSearchBox", newDocumentTypesName);

        mainContent.findAndClickElement("NotationApplyButton");
    }

    @Then("^Success Edit message should be displayed for Notation Keys$")
    public void successEditMessageShouldBeDisplayedForNotationKeys() {
        mainContent.findElementAndVerifyContainsText("NotationKeyEditSuccessfullyMessage","Notation Key successfully updated");

    }

    @When("^User can Notation Keys delete the \"([^\"]*)\"$")
    public void userCanNotationKeysDeleteThe(String documenTypesToDelete)  {
        dialogContent.editAndDeleteFunction(documenTypesToDelete, "Delete");
        dialogContent.findAndClickElement("yesButton");
}

    @Then("^Success delete message should be displayed for Notation Keys$")
    public void successDeleteMessageShouldBeDisplayedForNotationKeys() {
        mainContent.findElementAndVerifyContainsText("NotationKeyDeleteSuccessfullyMessage","Notation Key successfully deleted");
    }
}
