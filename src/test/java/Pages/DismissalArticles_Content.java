package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DismissalArticles_Content extends Parent {

    WebElement currentElement;
    List<WebElement> currentList;

    public DismissalArticles_Content() {

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

// todo dismissalArticles create

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResourcess;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement setup;

    @FindBy(xpath = "(//span[text()='Dismissal Articles'])[1]")
    private WebElement dismissalArticles;

    @FindBy(xpath = "//h3[text()='  Dismissal Articles ']")
    private WebElement dismissalArticlesTittle;


    @FindBy(xpath = "//ms-add-button[@tooltip='DISMISSAL_ARTICLE.TITLE.ADD']")
    private WebElement addButtonArticles;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameArticle;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='description']/input")
    private WebElement description;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButtonArticle;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement message;

    @FindAll({
            @FindBy(xpath = "//div[@id='toast-container']")
    })
    private List<WebElement> messageList;




    @FindAll({
            @FindBy(css="ms-edit-button.ng-star-inserted")})
    private List<WebElement> editButtonList;


    @FindAll({
            @FindBy (css = "ms-delete-button.ng-star-inserted") })
    private List<WebElement> deleteButtonList;

    @FindAll({
            @FindBy (css = "tbody>tr>td:nth-child(2)") })
    private List<WebElement> dismissalnamelist;

    @FindBy(css = "button[type='submit']")
    private WebElement yesButton;



    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']/input")
    private WebElement dismissalnameSearch;

    @FindBy(xpath = "//ms-search-button")
    private WebElement searchButton;




    public void findAndClickElement(String elementName) {

        switch (elementName) {

            case "loginButton":
                currentElement = loginButton;
                break;

            case "gotItButton":
                currentElement = gotItButton;
                break;

            case "gotItBtn":
                if (gotItBtns.size() == 0)
                    return;

                currentElement = gotItButton;
                break;


            case "humanResourcess":
                currentElement = humanResourcess;
                break;

            case "setup":
                currentElement = setup;
                break;

            case "dismissalArticles":
                currentElement = dismissalArticles;
                break;


            case "addButtonArticles":
                currentElement = addButtonArticles;
                break;

            case "saveButtonArticle":
                currentElement = saveButtonArticle;
                break;


            case "yesButton":
                currentElement = yesButton;
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

            case "nameArticle":
                currentElement = nameArticle;
                break;
            case "description":
                currentElement = description;
                break;


            case "dismissalnameSearch":
                currentElement = dismissalnameSearch;
                break;


        }

        sendKeysElement(currentElement, text);
    }

    public void findElementAndVerifyContainsText(String TextName, String msg) {

        switch (TextName) {

            case "message":
                currentElement = message;
                break;
//
//            case "ErrorMessage":
//                currentElement = ErrorMessage;
//                break;

            case "dismissalArticlesTittle":
                currentElement = dismissalArticlesTittle;
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



        List<WebElement> nameListNew = waitVisibleListAllElement(dismissalnamelist);
        for (int i = 0; i < nameListNew.size(); i++) {
            if (nameListNew.get(i).getText().equalsIgnoreCase(subjectName)) {
                clickFunction(btnList.get(i));
            }
        }
    }



    public void checkElementsintheList(String listName, String text) {

        switch (listName) {

            case "dismissalnamelist":
                currentList = dismissalnamelist;
                break;
        }

        for (WebElement n : currentList) {

            Assert.assertTrue(n.getText().contains(text));
        }
    }
}
