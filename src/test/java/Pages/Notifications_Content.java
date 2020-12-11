package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Notifications_Content extends Parent {

    WebElement currentElemet;
    List<WebElement> currentList;
    By currentolocater;

    public Notifications_Content() {

        PageFactory.initElements(driver, this);

    }



    @FindBy(xpath = "//ms-add-button//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement inputNatificationName;

    @FindBy(xpath = "//ms-save-button/button")
    private WebElement saveButton;

    @FindBy(css = "div[id='toast-container']")
    private WebElement containsmesaj;

    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@data-placeholder='Name']")
    private WebElement nameSearch;

    @FindBy(xpath = "//ms-search-button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button/button")
    private WebElement deletButton;

    @FindBy(xpath = "//span[text()=' Yes ']")
    private WebElement yesButton;

    @FindBy(xpath = "//ms-edit-button/button")
    private WebElement editButton;


    @FindAll(

            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-title mat-column-title ng-tns-c348-142 ng-star-inserted']")}
    )
    public List<WebElement> namelist;


    @FindAll(

            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-shortName mat-column-shortName ng-tns-c348-44 ng-star-inserted']")}
    )
    public List<WebElement> Shortnamelist;


    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement firstSetup;


    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Messaging']")
    private WebElement messaging;

    @FindBy(xpath = "//span[text()='Notifications']")
    private WebElement notifications;

    @FindBy(xpath = "//div//h3[text()='  Notifications ']")
    private WebElement notificationsPageTitle;

    @FindBy(xpath = "//mat-select[@role='combobox']")
    private WebElement type;

    @FindBy(xpath = "//span[text()=' Student Payment Time ']")
    private WebElement studentPayment;

    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    private WebElement description;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mr-16 mat-button mat-icon-button mat-button-base ng-star-inserted']")
    private WebElement backbutton;



    public void findAndClickElement(String elementName) {

        switch (elementName) {


            case "addbutton":
                currentElemet = addButton;
                break;

            case "saveButton":
                currentElemet = saveButton;
                break;
            case "searchButton":
                currentElemet = searchButton;
                break;
            case "deletButton":
                currentElemet = deletButton;
                break;
            case "yesButton":
                currentElemet = yesButton;
                break;
            case "editButton":
                currentElemet = editButton;
                break;

            case "firstSetup":
                currentElemet = firstSetup;
                break;

            case "parameters":
                currentElemet = parameters;
                break;

            case "messaging":
                currentElemet = messaging;
                break;
            case "notifications":
                currentElemet = notifications;
                break;
            case "type":
                currentElemet = type;
                break;
            case "studentPayment":
                currentElemet = studentPayment;
                break;
            case "backbutton":
                currentElemet = backbutton;
                break;



        }

        clickFunction(currentElemet);
    }


    public void findElementAndSendKeys(String elementName, String text) {

        switch (elementName) {


            case "inputNatificationName":
                currentElemet = inputNatificationName;
                break;

            case "nameSearch":
                currentElemet = nameSearch;
                break;

            case "description":
                currentElemet = description;
                break;


        }

        sendKeysElement(currentElemet, text);
    }

    public void findElementAndVerifyContainsText(String elementname, String mesaj) {

        switch (elementname) {


            case "notificationsPageTitle":
                currentElemet = notificationsPageTitle;
                break;


            case "containsmesaj":
                currentElemet = containsmesaj;
                break;

            case "errorMessage":
                currentElemet = errorMessage;
                break;

        }

        verifyElementContainsText(currentElemet, mesaj);

    }

    public void buttonisEnabled(String elementname) {

        switch (elementname) {

            case "saveButton":
                currentElemet = saveButton;
                break;


        }

        Assert.assertFalse(saveButton.isEnabled());

    }

    public void click_on_an_Element_in_a_ListWithindex(String listName, String indexnumber) {

        int intindexnumber = Integer.parseInt(indexnumber);

        switch (listName) {

//            case "positionSalaryIcons":
//                currentList = positionSalaryIcons;
//                currentolocater = By.xpath("//fa-icon[@class='ng-fa-icon ng-star-inserted']");
//                break;


        }

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(currentolocater, 0));
        System.out.println("liste size:" + currentList.size());
//        for (WebElement n:currentList) {
//            System.out.println(n.getText());
//        }

        currentList.get(intindexnumber).click();

    }

    public void check_if_the_Elements_in_theListContainText(String listName, String text) {

        switch (listName) {

            case "namelist":
                currentList = namelist;
                break;

            case "Shortnamelist":
                currentList = Shortnamelist;
                break;


        }

        for (WebElement n : currentList) {

            Assert.assertTrue(n.getText().contains(text));
        }


    }














}
