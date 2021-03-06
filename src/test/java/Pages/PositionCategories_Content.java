package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PositionCategories_Content extends Parent {

    WebElement currentElement;
    List<WebElement> currentList;

    public PositionCategories_Content() {

        PageFactory.initElements(driver, this);
    }

    // todo Login

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(xpath = "//button[@aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Got it!']")
    private WebElement gotItButton;

    @FindAll({
            @FindBy(linkText = "Got it!")
    })
    private List<WebElement> gotItBtns;



   // todo Position Categories create

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResources;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement setup3;

    @FindBy(xpath = "//span[text()='Position Categories']")
    private WebElement positionCategories;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindBy(xpath = "//h3[text()='  Position Categories ']")
    private WebElement positionCategoriesTittle;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy (xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement name;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement message;

    @FindAll({
            @FindBy(xpath = "//div[@id='toast-container']")
    })
    private List<WebElement> messageList;


    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']/input")
    private WebElement nameSearch;

    @FindBy(xpath = "//ms-search-button")
    private WebElement searchButton;


    @FindAll({
            @FindBy(css="ms-edit-button.ng-star-inserted")})
    private List<WebElement> editButtonList;


    @FindAll({
            @FindBy (css = "ms-delete-button.ng-star-inserted") })
    private List<WebElement> deleteButtonList;


    @FindAll({
            @FindBy (css = "tbody>tr>td:nth-child(2)") })
    private List<WebElement> namelist;

    @FindBy(css = "button[type='submit']")
    private WebElement yesButton;



    public void findAndClickElement(String elementName) {

        switch (elementName) {

            case "loginButton":
                currentElement = loginButton;
                break;

            case "gotItButton":
                currentElement = gotItButton;
                break;

            case "addButton":
                currentElement = addButton;
                break;

            case "searchButton":
                currentElement = searchButton;
                break;

            case "saveButton":
                currentElement = saveButton;
                break;

            case "gotItBtn":
                if (gotItBtns.size() == 0)
                    return;

                currentElement = gotItButton;
                break;


            case "yesButton":
                currentElement = yesButton;
                break;

            case "humanResources":
                currentElement = humanResources;
                break;

            case "setup3":
                currentElement = setup3;
                break;

            case "positionCategories":
                currentElement = positionCategories;
                break;
        }

        clickFunction(currentElement);
    }


    public void findElementAndSendKeys(String elementName, String text) {

        switch (elementName) {

            case "username":
                currentElement = username;
                break;

            case "password":
                currentElement = password;
                break;

            case "name":
                currentElement = name;
                break;

            case "nameSearch":
                currentElement = nameSearch;
                break;

            case "nameInput":
                currentElement = nameInput;
                break;
        }

        sendKeysElement(currentElement, text);
    }


    public void findElementAndVerifyContainsText(String TextName, String msg) {

        switch (TextName) {

            case "message":
                currentElement = message;
                break;

            case "ErrorMessage":
                currentElement = ErrorMessage;
                break;

            case "positionCategoriesTittle":
                currentElement = positionCategoriesTittle;
                break;


        }
        verifyElementContainsText(currentElement, msg);
    }



    public  void editAndDeleteFunction(String subjectName,String editorDelete) {

        if (messageList.size() > 0) {
             if (message.isDisplayed())
            wait.until(ExpectedConditions.invisibilityOfAllElements(message));
        }

        List<WebElement>btnList;


        if (editorDelete.equalsIgnoreCase("delete"))
            btnList=waitVisibleListAllElement(deleteButtonList);
        else
            btnList=waitVisibleListAllElement(editButtonList);



        List<WebElement> nameListNew = waitVisibleListAllElement(namelist);
        for (int i = 0; i < nameListNew.size(); i++) {
            if (nameListNew.get(i).getText().equalsIgnoreCase(subjectName)) {
                clickFunction(btnList.get(i));
            }
        }
    }



    public void checkElementsintheList(String listName, String text) {

        switch (listName) {

            case "namelist":
                currentList = namelist;
                break;
        }

        for (WebElement n : currentList) {

            Assert.assertTrue(n.getText().contains(text));
        }
    }
}