package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DialogContentBudgetProject extends Parent {

    WebElement myElement;

    public DialogContentBudgetProject() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mat-input-0")    private WebElement username;
    @FindBy(id = "mat-input-1")    private WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")    private WebElement loginButton;
    @FindBy(linkText = "Got it!")    private WebElement gotItButton;
    @FindAll({@FindBy(linkText = "Got it!") })   private List<WebElement> gotItBtns;
    @FindBy (xpath = "//span[text()='Dashboard ']")  private WebElement dashboard;

    @FindBy(xpath = "//span[text()='Budget']") private WebElement budget;
    @FindBy(xpath = "(//span[text()='Setup'])[6]") private WebElement setupBudget;
    @FindBy(xpath = "(//span[text()='Budget Projects'])") private WebElement budgetProjects;
    @FindBy(xpath = "(//*[@id=\'container-2\']//h3)") public WebElement titleBudgetProjects;
    //    @FindBy (xpath = "//ms-add-button[contains(@tooltip,'TITLE')]//button")    private WebElement addButton;
    @FindBy (xpath = "//ms-add-button[contains(@tooltip,'.ADD')]")    private WebElement addButton;
    @FindBy (css = "ms-text-field[formcontrolname='name']>input")    private WebElement name;
    @FindBy (css = "input[formcontrolname='code']") private WebElement accountCode;
    @FindBy(xpath = "//ms-save-button//button") private WebElement saveButton;
    @FindBy (css = "div#toast-container")    private WebElement message;  //   div[role='allertdialog']
    @FindAll({ @FindBy(css = "div#toast-container") })    private List<WebElement> messageList;
    @FindBy (css = "ms-delete-button.ng-star-inserted")    private WebElement deleteButton;
    @FindAll({ @FindBy (css = "ms-delete-button.ng-star-inserted") })  private List<WebElement> deleteButtonList;
    @FindBy(css = "button[type='submit']")    private WebElement yesButton;


    @FindAll({ @FindBy (css = "tbody>tr>td:nth-child(2)") })  private List<WebElement> nameList;



    public void findElementAndClickFunction(String elementName) {

        switch (elementName) {
            case "loginButton": myElement = loginButton;break;
            case "gotItButton":   if (gotItBtns.size() == 0) return; myElement = gotItButton; break;
            case "budget": myElement = budget;break;
            case "setupBudget": myElement = setupBudget;break;
            case "budgetProjects": myElement = budgetProjects;break;
            case "addButton": myElement = addButton;break;
            case "saveButton": myElement = saveButton;break;
            case "deleteButton": myElement = deleteButton;break;
            case "yesButton": myElement = yesButton;break;
        }

        clickFunction(myElement);
    }


    public void findElementAndSendKeysFunction(String elementName, String value) {

        switch (elementName) {
            case "username": myElement = username; break;
            case "name": myElement = name; break;
            case "password": myElement = password; break;
            case "accountCode": myElement = accountCode; break;

        }

        sendKeysElement(myElement, value);
    }


    public void findElementAndFindVerifyContainsText(String elementName, String text) {
        switch (elementName) {
            case "dashboard": myElement = dashboard;break;
            case "successfully": myElement = message;break;
        }

        verifyElementContainsText(myElement, text);
    }

    public void deleteFunction(String value){

        if (messageList.size() > 0) {
//            if (message.isDisplayed())
            wait.until(ExpectedConditions.invisibilityOfAllElements(message));
        }

        for (int i = 0; i < nameList.size(); i++) {

            if (nameList.get(i).getText().equalsIgnoreCase(value)) {
                clickFunction(deleteButtonList.get(i));
                break;
            }
        }
    }

    public void checkElementActive(String elementName) {

        switch (elementName) {
            case "saveButton": myElement = saveButton;break;

        }


        Assert.assertTrue(myElement.isDisplayed());
        Assert.assertFalse(myElement.isEnabled());
        System.out.println("Texti:  "   +myElement.getText());
        System.out.println("Enable mi? " + myElement.isEnabled());
        System.out.println("Displayed mi? " + myElement.isDisplayed());



    }






}
