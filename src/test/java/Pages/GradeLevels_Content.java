package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class GradeLevels_Content extends  Parent{

    WebElement currentElement;
    List<WebElement> currentList;


    public GradeLevels_Content() {

        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "mat-input-0")
    private WebElement username;
    @FindBy(id = "mat-input-1")
    private WebElement password;
    @FindBy(xpath = "//button[@aria-label='LOGIN']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[text()='Got it!']")
    private WebElement gotItButton;

    //TODO
    @FindBy (xpath = "//ms-add-button[contains(@tooltip,'.ADD')]//button")
    private WebElement addButton;
    @FindBy (css = "ms-text-field[formcontrolname='name']>input")
    private WebElement nameBox;
    @FindBy (css = "ms-text-field[formcontrolname='shortName']>input")
    private WebElement shortNameBox;
    @FindBy (css = "ms-text-field[formcontrolname='order']>input")
    private WebElement order;
    @FindBy(xpath = "//ms-save-button//button")
    public WebElement saveButton;

    //TODO NAVBAR elements:
    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setup;
    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;
    @FindBy(xpath = "//span[text()='Grade Levels']")
    private WebElement gradeLevels;

    //TODO Dialog Content
    @FindBy(xpath = "//span[text()='Next Grade']")
    private WebElement nextGrade;
    @FindBy(css = "[id='mat-option-135']")
    private WebElement option1;




    @FindBy (css ="div#toast-container")
    public WebElement message;  //   div[role='allertdialog']

    //edit buttonların Listesi
    @FindAll({@FindBy(css="ms-edit-button.ng-star-inserted")})
    private List<WebElement> editButtonList;
    // sol taraftaki isimleri listesi
    @FindAll({ @FindBy (css = "tbody>tr>td:nth-child(2)") })
    private List<WebElement> nameList;
    //deletebuton list
    @FindAll({ @FindBy (css = "ms-delete-button.ng-star-inserted") })
    private List<WebElement> deleteButtonList;
//  Aşağıdaki mesajlist ekranda çıkan got it veya succus mesajlarını
//  edit delete de beklerken sıkıntı çıkmasın diye eklendi

    @FindAll({ @FindBy(css = "div#toast-container") })
    private List<WebElement> messageList;


    @FindAll({
            @FindBy(linkText = "Got it!")
    })
    private List<WebElement> gotItBtns;

    //silerken tıklatacağım save button
    @FindBy(css = "button[type='submit']")
    private WebElement yesButton;

    @FindAll({
            @FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-tns-c348-75 ng-star-inserted']")
    })
    public List<WebElement> namelist;




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

            case "saveButton":
                currentElement = saveButton;
                break;

            case "gotItBtn":
                // bu eleman yok ise çoklu olarak yinede bulduk
                // eğer gerçekten yok ise size 0 olacağı için
                // bekletmeye düşmesin diye fonksiyonu geri gönderdik.

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

            case "gradeLevels":
                currentElement = gradeLevels;
                break;

            case "nextGrade":
                currentElement = nextGrade;
                break;

            case "option1":
                currentElement = option1;
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

            case "nameBox":
                currentElement = nameBox;
                break;

            case "shortNameBox":
                currentElement = shortNameBox;
                break;

            case "order":
                currentElement = order;
                break;


        }

        sendKeysElement(currentElement, text);
    }



    public void findElementAndVerifyContainsText(String TextName, String msg) {

        switch (TextName) {

            case "message":
                currentElement = message;
                break;

        }
        verifyElementContainsText(currentElement, msg);
    }


//TODO  eski ayrı ayrı edit delete

//    public void editFunction(String value){
//
//        if (messageList.size() > 0) {
//            //if (message.isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOfAllElements(message));
//        }
//
//        for (int i = 0; i < nameList.size(); i++) {
//
//            if (nameList.get(i).getText().equalsIgnoreCase(value)) {
//                clickFunction(editButtonList.get(i));
//                break;
//            }
//        }
//    }
//
//    public void deleteFunction(String value){
//
//        if (messageList.size() > 0) {
////            if (message.isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOfAllElements(message));
//        }
//
//        for (int i = 0; i < nameList.size(); i++) {
//
//            if (nameList.get(i).getText().equalsIgnoreCase(value)) {
//                clickFunction(deleteButtonList.get(i));
//                break;
//            }
//        }
//    }

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



        List<WebElement> nameListNew = waitVisibleListAllElement(nameList);
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
