package StepDefinitions;

import Pages.DialogContent;
import Pages.DocumentTypes_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_06_DocumentTypesSteps {


   DocumentTypes_Content mainContent=new DocumentTypes_Content();
   DialogContent dialogContent=new DialogContent();




    @Given("^Navigate to Document Types page$")
    public void navigateToDocumentTypesPage() {
        mainContent.findAndClickElement("SetupButton");
        mainContent.findAndClickElement("ParametersButton");
        mainContent.findAndClickElement("DocumentTypesButton");
        mainContent.findElementAndVerifyContainsText("DocumentTypesTittle","Document Types");

    }



    @Then("^Document Types title control$")
    public void documentTypesTitleControl() {
        mainContent.findElementAndVerifyContainsText("DocumentTypesTittle","Document Types");
    }


    @When("^New Document Creat as Name \"([^\"]*)\" as Description\"([^\"]*)\"$")
    public void newDocumentCreatAsNameAsDescription(String newdocumentname, String description)  {
        mainContent.findAndClickElement("addButton");
        mainContent.findAndClickElement("maximizesButton");

        mainContent.findElementAndSendKeys("newDocumentNameBox",newdocumentname);
        mainContent.findElementAndSendKeys("descriptionBox",description);
        mainContent.findAndClickElement("stageButton");
        mainContent.findAndClickElement("studentRegistrationButton");





        mainContent.findAndClickElement("saveButton");

    }




    @Then("^Success message should be displayed for New Document$")
    public void successMessageShouldBeDisplayedForNewDocument() {
        mainContent.findElementAndVerifyContainsText("creatSuccessfullyMessage","Document successfully created");


    }


    @When("^User can Document Types edit the name  \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userCanDocumentTypesEditTheNameTo(String documentTypesName, String newDocumentTypesName) {
        dialogContent.editAndDeleteFunction(documentTypesName,"edit");

        dialogContent.findElementAndSendKeys("name", newDocumentTypesName);

        dialogContent.findAndClickElement("saveButton");

    }



    @Then("^Success Edit message should be displayed for Document Types$")
    public void successEditMessageShouldBeDisplayedForDocumentTypes() {
        dialogContent.findElementAndVerifyContainsText("message", "successfully");
    }

    @When("^User can Document Types delete the \"([^\"]*)\"$")
    public void userCanDocumentTypesDeleteThe(String documenTypesToDelete)  {
        dialogContent.editAndDeleteFunction(documenTypesToDelete, "Delete");
        dialogContent.findAndClickElement("yesButton");

    }


    @Then("^Success delete message should be displayed for Document Types$")
    public void successDeleteMessageShouldBeDisplayedForDocumentTypes() {
        dialogContent.findElementAndVerifyContainsText("message", "successfully");
    }

    @When("^User can Document Types search the \"([^\"]*)\"$")
    public void userCanDocumentTypesSearchThe(String searchedname)  {
        mainContent.findElementAndSendKeys("nameSearch",searchedname);
        mainContent.findAndClickElement("searchButton");


    }

    @Then("^Send text in  namebox and search Document Type$")
    public void sendTextInNameboxAndSearchDocumentType(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {

            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
            mainContent.findElementAndSendKeys(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }
    }




        @And("^click on Search Button of Document Type$")
        public void clickOnSearchButtonOfDocumentType (DataTable elements){
            List<String> elementstoClick = elements.asList(String.class);
            for (String n : elementstoClick) {
                System.out.println(n);
                mainContent.findAndClickElement(n);
            }
        }


    @Then("^check to list with name Document Type$")
    public void checkToListWithNameDocumentType(DataTable elements) {

        List<List<String>>  elementsNameAndValue=elements.asLists(String.class);

        for (int i = 0; i <elementsNameAndValue.size() ; i++) {

            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
            mainContent.checkElementsintheList(elementsNameAndValue.get(i).get(0),elementsNameAndValue.get(i).get(1));

        }
    }




}