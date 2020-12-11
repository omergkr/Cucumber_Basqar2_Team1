package StepDefinitions;

import Pages.DialogContent;
import Pages.Discounts_Content;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class US_04_DiscountsSteps {

    Discounts_Content discountsContent=new Discounts_Content();

DialogContent dialogContent1 = new DialogContent();


    @When("^When User Create a Discount name as \"([^\"]*)\"  name as \"([^\"]*)\" name as \"([^\"]*)\"$")
    public void whenUserCreateADiscountNameAsNameAsNameAs(String arg0, String arg1, String arg2) {
        dialogContent1.findAndClickElement("addButton");

        discountsContent.findElementAndSendKeys("description", arg0);
        discountsContent.findElementAndSendKeys("integrationCode", arg1);
        discountsContent.findElementAndSendKeys("priority", arg2);
        dialogContent1.findAndClickElement("saveButton");

    }



    @When("^Discount click on button with button name$")
    public void discountClickOnButtonWithButtonName() {

        discountsContent.findAndClickElement("setupOne");
        discountsContent.findAndClickElement("parameters");
        discountsContent.findAndClickElement("Discount");

    }

    @Then("^Discount User delet the \"([^\"]*)\"$")
    public void discountUserDeletThe(String DescriptionNameDelete)  {

        discountsContent.findElementAndSendKeys("searchDiscount",DescriptionNameDelete);
        dialogContent1.findAndClickElement("searchButton");

        dialogContent1.editAndDeleteFunction(DescriptionNameDelete,"Delete");
        dialogContent1.findAndClickElement("yesButton");

    }

    @Then("^Discount User edit the \"([^\"]*)\" to \"([^\"]*)\"$")
    public void discountUserEditTheTo(String searchDiscountName, String newName) {

        discountsContent.findElementAndSendKeys("searchDiscount",searchDiscountName);
        dialogContent1.findAndClickElement("searchButton");

        dialogContent1.editAndDeleteFunction(searchDiscountName, "edit");

        discountsContent.findElementAndSendKeys("description", newName);
        dialogContent1.findAndClickElement("saveButton");
    }

    @And("^Discount Succes message should be displayed$")
    public void discountSuccesMessageShouldBeDisplayed() {

        dialogContent1.findElementAndVerifyContainsText("message", "successfully");

    }
}




