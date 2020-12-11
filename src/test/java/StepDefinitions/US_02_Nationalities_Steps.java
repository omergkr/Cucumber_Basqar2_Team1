package StepDefinitions;


import Pages.Nationalities_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_02_Nationalities_Steps {

    Nationalities_Content nationalitiesContent = new Nationalities_Content();


    @When("^Click on the element in the content class$")
    public void clickOnTheElementInTheContentClass(DataTable elements) {

        List<String> elementsToClick=elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            System.out.println( elementsToClick.get(i));
            nationalitiesContent.findAndClickElement(elementsToClick.get(i));

        }

    }


    @When("^User sending the keys in the  content class$")
    public void userSendingTheKeysInTheContentClass(DataTable elements) {

        List< List<String> >  elementsNameAndValue = elements.asLists(String.class);

        for(int i=0;i<elementsNameAndValue.size();i++) {

            System.out.println(elementsNameAndValue.get(i).get(0)); // elemanın adı
            System.out.println(elementsNameAndValue.get(i).get(1)); // elemanın gönderilecek değeri

            nationalitiesContent.findElementAndSendKeys(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
            }
        }


//    @Then("^Control to verification message$")
//    public void controlToVerificationMessage(WebElement element, String mesaj) {
//
//        nationalitiesContent.verifyElementContainsText(element,mesaj);
//
//    }


    @And("^User edit the nationalities \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditTheNationalities(String Nationalities, String newNationalities) {

        nationalitiesContent.editAndDeleteFunction(Nationalities,"edit");
        nationalitiesContent.findElementAndSendKeys("name",newNationalities);
        nationalitiesContent.findAndClickElement("saveButton");
    }

    @And("^User delete the nationalities \"([^\"]*)\"$")
    public void userDeleteTheNationalities(String nameOfNationalitiesToDelete) {

        nationalitiesContent.editAndDeleteFunction(nameOfNationalitiesToDelete,"delete");
        nationalitiesContent.findAndClickElement("yesButton");
    }

    @Then("^Success message should be displayed$")
    public void success_message_should_be_displayed() {
        nationalitiesContent.findElementAndVerifyContainsText("message","successfully");
    }
}

