package StepDefinitions;
import Pages.PositionCategories_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_13_PositionCategoriesSteps {

    PositionCategories_Content positionCategories = new PositionCategories_Content();

    @When("^Click on the element in the position categories content class$")
    public void click_on_the_element_in_the_position_categories_content_class(DataTable elements) {

        List<String> elementsToClick = elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            System.out.println(elementsToClick.get(i));
            positionCategories.findAndClickElement(elementsToClick.get(i));
        }
    }


    @Then("^User sending the keys in the position categories content class$")
    public void user_sending_the_keys_in_the_position_categories_content_class(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            positionCategories.findElementAndSendKeys(elementsNameAndValue.get(i).get(0),
                    elementsNameAndValue.get(i).get(1));
        }
    }


    @Then("^Success Message should be displayed$")
    public void success_Message_should_be_displayed()  {

        positionCategories.findElementAndVerifyContainsText("message","successfully");
    }


    @When("^User edit the position categories \"([^\"]*)\" to \"([^\"]*)\"$")
    public void user_edit_the_position_categories_to(String positionCategoriesName, String newPositionCategoriesName) {

        positionCategories.editAndDeleteFunction(positionCategoriesName, "edit");
        positionCategories.findElementAndSendKeys("nameInput", newPositionCategoriesName);
        positionCategories.findAndClickElement("saveButton");
    }


    @Then("^User delete the position categories \"([^\"]*)\"$")
    public void user_delete_the_position_categories(String name) {

        positionCategories.editAndDeleteFunction(name, "delete");
        positionCategories.findAndClickElement("yesButton");
    }


    @Then("^User should Position Categories successfully$")
    public void user_should_Position_Categories_successfully() {

        positionCategories.findElementAndVerifyContainsText("positionCategoriesTittle","Position Categories");
    }

    @Then("^check to list with name position categories$")
    public void check_to_list_with_name_position_categories(DataTable elements) {

        List<List<String>> elementsNameAndValue = elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {

            System.out.println(elementsNameAndValue.get(i).get(0));
            System.out.println(elementsNameAndValue.get(i).get(1));
            positionCategories.checkElementsintheList(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }
    }

}
