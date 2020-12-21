package StepDefinitions;

import Pages.DismissalArticles_Content;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_14_DismissalArticlesSteps {


    DismissalArticles_Content dismissalArticles =new DismissalArticles_Content();

    @When("^Click on the element in the Dismissal Articles page content class$")
    public void clickOnTheElementInTheDismissalArticlesPageContentClass(DataTable elements) {

        List<String> elementsToClick = elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            System.out.println(elementsToClick.get(i));
            dismissalArticles.findAndClickElement(elementsToClick.get(i));


    }}

    @Then("^User should Dismissal Articles successfully$")
    public void userShouldDismissalArticlesSuccessfully() {

       dismissalArticles.findElementAndVerifyContainsText("dismissalArticlesTittle","Dismissal Articles");


    }


    @Then("^User sending the keys in the Dismissal Articles content class$")
    public void userSendingTheKeysInTheDismissalArticlesContentClass(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            dismissalArticles.findElementAndSendKeys(elementsNameAndValue.get(i).get(0),
                    elementsNameAndValue.get(i).get(1));


    }
        }

    @Then("^Dismissal Articles Success Message should be displayed$")
    public void dismissalArticlesSuccessMessageShouldBeDisplayed() {

        dismissalArticles.findElementAndVerifyContainsText("message","successfully");

    }

    @When("^User edit the Dismissal Articles \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userEditTheDismissalArticlesTo(String dismissalArticlesname, String newdismissalArticlesname)   {

       dismissalArticles.editAndDeleteFunction(dismissalArticlesname, "edit");
        dismissalArticles.findElementAndSendKeys("nameArticle", newdismissalArticlesname);
        dismissalArticles.findAndClickElement("saveButtonArticle");


    }

    @And("^User delete the Dismissal Articles \"([^\"]*)\"$")
    public void userDeleteTheDismissalArticles(String disDeletName)  {

        dismissalArticles.editAndDeleteFunction(disDeletName, "delete");
       dismissalArticles.findAndClickElement("yesButton");


    }

    @Then("^check to list with name Dismissal Articles$")
    public void checkToListWithNameDismissalArticles(DataTable elements) {


        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {

            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
           dismissalArticles.checkElementsintheList(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));

    }
}
}


