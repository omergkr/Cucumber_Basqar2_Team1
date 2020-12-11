package StepDefinitions;

import Pages.GradeLevels_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class Us_05_GradeLevelSteps {
    GradeLevels_Content gradeLevels_content=new GradeLevels_Content();


    @When("^click on button with button at Grade Level$")
    public void clickOnButtonWithButtonAtGradeLevel(DataTable elements) {
        List<String> elementsToClick=elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            gradeLevels_content.findAndClickElement(elementsToClick.get(i));

        }

    }

    @Then("^Send text with inputbox at Grade Level$")
    public void sendTextWithInputboxAtGradeLevel(DataTable elements) {

        List<List<String>> elementsNameAndValue=elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            gradeLevels_content.findElementAndSendKeys(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }
    }



//    @Then("^Control to verification message$")
//    public void controlToVerificationMessage(WebElement element, String mesaj) {
//
//        gradeLevels_content.verifyElementContainsText(element,mesaj);
//
//    }

    @And("^User edit the \"([^\"]*)\" to \"([^\"]*)\" at GradeLevelName$")
    public void userEditTheToAtGradeLevelName(String degisecek, String degismis) {
        gradeLevels_content.editAndDeleteFunction(degisecek,"edit");
        gradeLevels_content.findElementAndSendKeys("nameBox",degismis);
    }

    @And("^User delete the \"([^\"]*)\" at Grade Level$")
    public void userDeleteTheAtGradeLevel(String nameOfElementToDelete) {
        gradeLevels_content.editAndDeleteFunction(nameOfElementToDelete,"delete");
    }

    @Then("^User should see \"([^\"]*)\" at Grade Level$")
    public void userShouldSeeAtGradeLevel(String alertBox) {
        gradeLevels_content.verifyElementContainsText(gradeLevels_content.message, "succes");
    }












}
