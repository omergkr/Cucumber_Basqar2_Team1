package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Attestations_Content extends Parent {

    WebElement currentElement;
    List<WebElement> currentList;

    public Attestations_Content() {

        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(linkText = "Got it!")
    private WebElement gotItBtn;

    @FindBy(linkText = "Human Resources")
    private WebElement humanBtn;

    @FindBy(linkText = "Attestations")
    private WebElement attestationBtn;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement SetupBtn;


    @FindBy(xpath = "//ms-add-button//button")
    private WebElement addBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;



    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy (xpath="//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    public WebElement searchName;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//span[text()=' Yes ']")
    private WebElement yesButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement newSubjectError;

    @FindAll({
            @FindBy(xpath = "//div[@id='toast-container']")
    })
    private List<WebElement> msjContainers;

    @FindAll({
            @FindBy(xpath = "//table/tbody/tr/td[2]")
    })
    public List<WebElement> nameList;

    @FindAll({
            @FindBy(xpath = "//ms-delete-button/button")
    })
    public List<WebElement> deleteButtonList;
    @FindAll({
            @FindBy(xpath = "//ms-edit-button/button")
    })
    public List<WebElement> editButtonList;




    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement msjContainer;


    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement ErrorMessage;


    @FindBy(xpath = "//h3[text()='  Attestations ']")
    private WebElement AttestationsPageTitle;



    public void findAndClickElement(String elementName) {

        switch (elementName) {

            case "loginButton":
                currentElement = loginButton;
                break;

            case "gotItButton":
                currentElement = gotItBtn;
                break;

            case "humanBtn":
                currentElement = humanBtn;
                break;

            case "SetupBtn":
                currentElement = SetupBtn;
                break;

            case "attestationBtn":
                currentElement = attestationBtn;
                break;


            case "addBtn":
                currentElement = addBtn;
                break;

            case "yesButton":
                currentElement = yesButton;
                break;

            case "saveButton":
                currentElement = saveButton;
                break;

            case "searchButton":
                currentElement = searchButton;
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

            case "nameInput":
                currentElement = nameInput;
                break;




            case "searchName":
                currentElement = searchName;
                break;


        }

        sendKeysElement(currentElement, text);
    }



    public  void editAndDeleteFunction(String subjectName,String editorDelete) {

        if (msjContainers.size() > 0) {
            if (newSubjectError.isDisplayed())
                wait.until(ExpectedConditions.invisibilityOfAllElements(newSubjectError));
        }


        List<WebElement> btnList;

        if (editorDelete.equalsIgnoreCase("delete"))
            btnList = waitVisibleListAllElement(deleteButtonList);
        else
            btnList = waitVisibleListAllElement(editButtonList);




        List<WebElement> nameListNew = waitVisibleListAllElement(nameList);
        for (int i = 0; i < nameListNew.size(); i++) {
            if (nameListNew.get(i).getText().equalsIgnoreCase(subjectName)) {
                clickFunction(btnList.get(i));
            }
        }
    }

    public void findElementAndVerifyContainsText(String ElementName, String msg) {
        switch (ElementName) {
            case "msjContainer":
                currentElement = msjContainer;
                break;

            case "ErrorMessage":
                currentElement = ErrorMessage;
                break;

            case "AttestationsPageTitle":
                currentElement = AttestationsPageTitle;
                break;
        }

        verifyElementContainsText(currentElement, msg);
    }

    public void checklist(String elementName,String text) {

        switch (elementName) {

            case "namelist":
                currentList = nameList;
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

