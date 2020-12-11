package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FeeContent extends Parent {

    WebElement currentElement;
   // WebElement myElement;
  //  List<WebElement> currentList;

    public FeeContent() {

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

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement SetupBtn;
    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement ParametersBtn;
    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement feeBtn;

    @FindBy(xpath = "//ms-add-button//button")
    private WebElement addBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']/input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy (xpath="//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    public WebElement searchFeeName;

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









    public void findAndClickElement(String elementName) {

        switch (elementName) {

            case "loginButton":
                currentElement = loginButton;
                break;

            case "gotItButton":
                currentElement = gotItBtn;
                break;


            case "SetupBtn":
                currentElement = SetupBtn;
                break;


            case "ParametersBtn":
                currentElement = ParametersBtn;
                break;

            case "feeBtn":
                currentElement = feeBtn;
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


            case "codeInput":
                currentElement = codeInput;
                break;

            case "integrationCode":
                currentElement = integrationCode;
                break;

            case "priorityCode":
                currentElement = priorityCode;
                break;


            case "searchFeeName":
                currentElement = searchFeeName;
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

}

