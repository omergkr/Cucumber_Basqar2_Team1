package StepDefinitions;

import Pages.Item_Categories_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_08_ItemCategoriesSteps {

    Item_Categories_Content item_categories_content = new Item_Categories_Content();


    @When("^page validation Item_Categories$")
    public void pageValidationItem_Categories() {
        item_categories_content.find_Element_And_Verify_Contains_Text("Item_Title", "Item Categories");
    }

    @Then("^Go to the Item_Categories page$")
    public void goToTheItem_CategoriesPage(DataTable elements) {

        List<String> elementstoClick = elements.asList(String.class);
        for (String n : elementstoClick) {
            System.out.println(n);
            item_categories_content.find_And_Click_Element(n);


        }

    }

    @Then("^Add New$")
    public void addNew() {
        item_categories_content.find_And_Click_Element("addButton");
        item_categories_content.find_Element_And_Send_Keys("nameBox", "Kitap");
        item_categories_content.find_And_Click_Element("userTypeclick");
        item_categories_content.find_And_Click_Element("userTypeSelect");
        item_categories_content.find_And_Click_Element("saveButton");

    }

    @And("^Check mesaj$")
    public void checkMesaj() {
        item_categories_content.find_Element_And_Verify_Contains_Text("message", "successfully");

    }


    @Then("^Searching by Item_Categories name as \"([^\"]*)\"$")
    public void searchingByItem_CategoriesNameAs(String incommingName) {
        item_categories_content.find_Element_And_Send_Keys("searchItemCategotiesName", incommingName);
        item_categories_content.find_And_Click_Element("searchButton");

    }

    @When("^Go to delete method \"([^\"]*)\"$")
    public void goToDeleteMethod(String deleteName) {

        item_categories_content.edit_And_Delete_Function(deleteName, "delete");
        item_categories_content.find_And_Click_Element("yesButton");


    }


    @When("^Go to edit method \"([^\"]*)\" to \"([^\"]*)\"$")
    public void goToEditMethodTo(String incomigName, String incomigNewName) {

        item_categories_content.edit_And_Delete_Function(incomigName, "edit");
        item_categories_content.find_Element_And_Send_Keys("nameInput", incomigNewName);
        item_categories_content.find_And_Click_Element("saveButton");

    }

    @Then("^Check name from list$")
    public void checkNameFromList(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {

            item_categories_content.check_Elements_in_the_Lists(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));


        }
    }

}