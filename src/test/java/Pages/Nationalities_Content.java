package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Nationalities_Content extends Parent {


    WebElement currentElement;
    List<WebElement> currentList;

    public Nationalities_Content() {

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



   // todo Nationalities create

    @FindBy (xpath = "(//span[text()='Setup'])")
    private WebElement setup;

    @FindBy (xpath = "(//span[text()='Parameters'])")
    private WebElement parameters;

    @FindBy (xpath = "(//span[text()='Nationalities'])")
    private WebElement nationalities;

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

            case "setup":
                currentElement = setup;
                break;

            case "parameters":
                currentElement = parameters;
                break;

            case "nationalities":
                currentElement = nationalities;
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
        }
        verifyElementContainsText(currentElement, msg);
    }



    public  void editAndDeleteFunction(String subjectName,String editorDelete) {

        if (messageList.size() > 0) {
            //  if (message.isDisplayed())
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

    public void elementisEnabled(String elementName) {

        switch (elementName) {

            case "saveButton":
                currentElement = saveButton;
                break;


        }

        Assert.assertFalse(currentElement.isEnabled());//Save buttonu gözüküp gözükmedigini kontrol ediyoruz


    }


    public void checklist(String elementName,String text) {

        switch (elementName) {

            case "namelist":
                currentList = namelist;
                break;
        }
        boolean control= true;


        if (currentList.size()!=0){
            for ( WebElement element : currentList) {
                if (!element.getText().contains(text)) {

                    control = false;
                    break;
                }
            }
            Assert.assertTrue(control);

        }


    }
}
