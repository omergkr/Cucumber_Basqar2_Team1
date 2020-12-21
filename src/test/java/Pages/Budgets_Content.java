package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Budgets_Content extends Parent {

    WebElement currentElement;
    List<WebElement> currentList;


    public Budgets_Content() {

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




    // todo Budgets create

    @FindBy (xpath = "(//span[text()='Budget'])")
    private WebElement budget;

    @FindBy (xpath = "(//span[text()='Budgets'])")
    private WebElement budgets;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy (xpath = "//ms-text-field[@formcontrolname='description']/input")  // input suz da gelıyor neden input yazıyoruz
    private WebElement descriptionBox;

    @FindBy (xpath = "//ms-text-field[@formcontrolname='year']/input")
    private WebElement year;


    @FindBy(xpath = "(//mat-select[@role='combobox'])[5]")   //  [5]
    private WebElement budgetGroup;

    @FindBy(xpath = "//span[text()=' Description ']")
    private WebElement description;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[7]")   // 7.
    private WebElement school;

    @FindBy(xpath = "//span[text()=' ErzincanCCCC High School ']")
    private WebElement highSchool;


    @FindBy(xpath = "(//mat-select[@role='combobox'])[8]")   // 8.
    private WebElement budgetType;

    @FindBy(xpath = "//span[text()=' Revision ']")
    private WebElement revision;


    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;


    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeButton;


    @FindBy(xpath = "//mat-select[@role='combobox']")   // 1.
    private WebElement budgetGroupSearch;


    @FindBy(xpath = "(//mat-select[@role='combobox'])[2]")   // 2.
    private WebElement schoolSearch;


    @FindBy(xpath = "//ms-search-button")
    private WebElement searchButton;


    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement message;


    @FindAll({
            @FindBy(xpath = "//div[@id='toast-container']")
    })
    private List<WebElement> messageList;


    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement ErrorMessage;



    @FindAll({
            @FindBy (css = "ms-delete-button.ng-star-inserted") })
    private List<WebElement> deleteButtonList;


    @FindAll({
            @FindBy(css="ms-edit-button.ng-star-inserted")})
    private List<WebElement> editButtonList;



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

            case "budget":
                currentElement = budget;
                break;

            case "budgets":
                currentElement = budgets;
                break;

            case "budgetGroup":
                currentElement = budgetGroup;
                break;

            case "description":
                currentElement = description;
                break;

            case "school":
                currentElement = school;
                break;

            case "highSchool":
                currentElement = highSchool;
                break;

            case "budgetType":
                currentElement = budgetType;
                break;

            case "revision":
                currentElement = revision;
                break;

            case "closeButton":
                currentElement = closeButton;
                break;

            case "budgetGroupSearch":
                currentElement = budgetGroupSearch;
                break;

            case "schoolSearch":
                currentElement = schoolSearch;
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

            case "descriptionBox":
                currentElement = descriptionBox;
                break;

            case "year":
                currentElement = year;
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
