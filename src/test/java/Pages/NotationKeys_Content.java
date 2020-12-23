package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class NotationKeys_Content extends Parent {



    WebElement currentElemet;
    List<WebElement> currentList;


    public NotationKeys_Content() {

        PageFactory.initElements(driver, this);

    }



    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement HumanResourcesButton;
    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement NotationSetupButton;
    @FindBy(xpath = "//span[text()='Notation Keys']")
    private WebElement NotationKeysButton;
    @FindBy(xpath = "//h3[text()='  Timesheet Notation Keys ']")
    private WebElement NotationKeysTittle;
    @FindBy(xpath = "//ms-add-button//button")
    private WebElement NotationAddButton;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement NotationInputName;
    @FindBy(xpath = "//input[@name='shortName']")
    private WebElement NotationInputShortName;
    @FindBy(xpath = "//input[@name='multiplier']")
    private WebElement NotationInputMultiplier;
    @FindBy(xpath = "//span[text()='Apply']")
    private WebElement NotationApplyButton;
    @FindBy(xpath = " //div[text()='Notation Key successfully created']")
    private WebElement NotationKeyCreatedSuccessfullyMessage;
    @FindBy(xpath = "//input[@data-placeholder='Name']")
    private WebElement NotationKeyNameSearchBox;
    @FindBy(xpath = "//span[text()=' Search ']")
    private WebElement NotationKeyNameSearchButton;
    @FindBy(xpath = "//input[@data-placeholder='Short Name']")
    private WebElement NotationKeyShortNameSearchBox;

    @FindAll(
            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-tns-c348-61 ng-star-inserted']")}
    )
    public List<WebElement> NotationKeyNameList;
    @FindAll(

            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-shortName mat-column-shortName ng-tns-c348-61 ng-star-inserted']")}
    )
    public List<WebElement> NotationKeyShortNameList;


    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement forEditNameSearchBox;
    @FindBy(xpath = "//div[text()='Notation Key successfully updated']")
    private WebElement NotationKeyEditSuccessfullyMessage;
    @FindBy(css = "button[type='submit']")
    private WebElement NotationKeyDeleteYesButton;
    @FindBy(xpath = "//div[text()='Notation Key successfully deleted']")
    private WebElement NotationKeyDeleteSuccessfullyMessage;





    public void findAndClickElement(String elementName) {

        switch (elementName) {


            case "HumanResourcesButton":
                currentElemet = HumanResourcesButton;
                break;
            case "NotationSetupButton":
                currentElemet = NotationSetupButton;
                break;
            case "NotationKeysButton":
                currentElemet = NotationKeysButton;
                break;
            case "NotationAddButton":
                currentElemet = NotationAddButton;
                break;
            case "NotationApplyButton":
                currentElemet = NotationApplyButton;
                break;
            case "NotationKeyNameSearchButton":
                currentElemet = NotationKeyNameSearchButton;
                break;
            case "NotationKeyDeleteYesButton":
                currentElemet = NotationKeyDeleteYesButton;
                break;
        }

        clickFunction(currentElemet);
    }


    public void findElementAndSendKeys(String elementName, String text) {

        switch (elementName) {


            case "NotationInputName":
                currentElemet = NotationInputName;
                break;
            case "NotationInputShortName":
                currentElemet = NotationInputShortName;
                break;
            case "NotationInputMultiplier":
                currentElemet = NotationInputMultiplier;
                break;
            case "NotationKeyNameSearchBox":
                currentElemet = NotationKeyNameSearchBox;
                break;
            case "NotationKeyShortNameSearchBox":
                currentElemet = NotationKeyShortNameSearchBox;
                break;
            case "forEditNameSearchBox":
                currentElemet = forEditNameSearchBox;
                break;














        }

        sendKeysElement(currentElemet, text);
    }

    public void findElementAndVerifyContainsText(String elementname, String mesaj) {

        switch (elementname) {


            case "NotationKeysTittle":
                currentElemet = NotationKeysTittle;
                break;
            case "NotationKeyCreatedSuccessfullyMessage":
                currentElemet = NotationKeyCreatedSuccessfullyMessage;
                break;
            case "NotationKeyEditSuccessfullyMessage":
                currentElemet = NotationKeyEditSuccessfullyMessage;
                break;
            case "NotationKeyDeleteSuccessfullyMessage":
                currentElemet = NotationKeyDeleteSuccessfullyMessage;
                break;

        }

        verifyElementContainsText(currentElemet, mesaj);

    }



    public void CheckNotationKeysListWithName(String listName, String text) {

        switch (listName) {

            case "NotationKeyNameList":
                currentList = NotationKeyNameList;
                break;

            case "NotationKeyShortNameList":
                currentList = NotationKeyShortNameList;
                break;


        }

        for (WebElement n : currentList) {

            Assert.assertTrue(n.getText().contains(text));
        }


    }

}

