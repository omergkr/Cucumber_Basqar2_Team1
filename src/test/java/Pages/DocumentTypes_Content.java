package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DocumentTypes_Content extends Parent {



    WebElement currentElemet;
    List<WebElement> currentList;


    public DocumentTypes_Content() {

        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement SetupButton;
    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement ParametersButton;
    @FindBy(xpath = "//span[text()='Document Types']")
    private WebElement DocumentTypesButton;
    @FindBy(xpath = "//h3[text()='  Document Types ']")
    private WebElement DocumentTypesTittle;

    @FindBy(xpath = "//ms-add-button//button")
    private WebElement addButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement newDocumentNameBox;
    //@FindBy(xpath = "(//mat-select[@formcontrolname='attachmentStages']")
    @FindBy(xpath = "//mat-form-field[@style='margin-bottom: 8px;'][2]")
    private WebElement stageButton;
    @FindBy(xpath = "//span[text()=' Student Registration ']")
    private WebElement studentRegistrationButton;
    @FindBy(xpath = "//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']")
    private WebElement backRaund;
    @FindBy(xpath = "//textarea[@data-placeholder='Description']")
    private WebElement descriptionBox;
    @FindBy(xpath = "//ms-save-button/button")
    private WebElement saveButton;
    @FindBy(xpath = "//div[text()='Document successfully created']")
    private WebElement creatSuccessfullyMessage;
    @FindBy(xpath = "//button[@aria-label='Maximizes']")
    private WebElement maximizesButton;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']/input")
    private WebElement nameSearch;

    @FindBy(xpath = "//ms-search-button")
    private WebElement searchButton;

    @FindAll(

            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-title mat-column-title ng-tns-c348-142 ng-star-inserted']")}
    )
    public List<WebElement> namelist;
    @FindAll(

            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-shortName mat-column-shortName ng-tns-c348-44 ng-star-inserted']")}
    )
    public List<WebElement> Shortnamelist;



























    public void findAndClickElement(String elementName) {

        switch (elementName) {


            case "SetupButton":
                currentElemet = SetupButton;
                break;
            case "ParametersButton":
                currentElemet = ParametersButton;
                break;
            case "DocumentTypesButton":
                currentElemet = DocumentTypesButton;
                break;
            case "addButton":
                currentElemet = addButton;
                break;
            case "stageButton":
                currentElemet = stageButton;
                break;
            case "studentRegistrationButton":
                currentElemet = studentRegistrationButton;
                break;
            case "backRaund":
                currentElemet = backRaund;
                break;

            case "saveButton":
                currentElemet = saveButton;
                break;
            case "maximizesButton":
                currentElemet = maximizesButton;
                break;
            case "searchButton":
                currentElemet = searchButton;
                break;



































        }

        clickFunction(currentElemet);
    }


    public void findElementAndSendKeys(String elementName, String text) {

        switch (elementName) {


            case "newDocumentNameBox":
                currentElemet = newDocumentNameBox;
                break;
            case "descriptionBox":
                currentElemet = descriptionBox;
                break;
            case "nameSearch":
                currentElemet = nameSearch;
                break;





        }

        sendKeysElement(currentElemet, text);
    }

    public void findElementAndVerifyContainsText(String elementname, String mesaj) {

        switch (elementname) {

            case "DocumentTypesTittle":
                currentElemet = DocumentTypesTittle;
                break;
            case "creatSuccessfullyMessage":
                currentElemet = creatSuccessfullyMessage;
                break;












        }

        verifyElementContainsText(currentElemet, mesaj);

    }



    public void checkElementsintheList(String listName, String text) {

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
}}
