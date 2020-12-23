package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Item_Categories_Content extends Parent {
    WebElement currentElement;
    List<WebElement> currentList;


    public Item_Categories_Content() {

        PageFactory.initElements(driver, this);

    }
/*
LOGIN KISMI
 */
    @FindBy(id = "mat-input-0")
    private WebElement username;
    @FindBy(id = "mat-input-1")
    private WebElement password;
    @FindBy(xpath = "//button[@aria-label='LOGIN']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[text()='Got it!']")
    private WebElement gotItButton;

    //TODO
     /*
    Item_Categories
     */
     @FindBy (xpath = "(//span[text()='Inventory'])[1]")
     private WebElement Inventory;

    @FindBy (xpath = "(//span[text()='Setup'])[4]")
    private WebElement Inventory_Setup;

    @FindBy (xpath = "(//span[text()='Item Categories'])[1]")
    private WebElement Item_Categories;

    @FindBy (xpath = "//h3[text()='  Item Categories ']")
    private WebElement Item_Title;

    @FindBy (xpath = "//ms-add-button[contains(@tooltip,'.ADD')]//button")
    private WebElement addButton;

    @FindBy (css = "ms-text-field[formcontrolname='name']>input")
    private WebElement nameBox;


    @FindBy (xpath = "//mat-chip-list/div/input")
    private WebElement userTypeclick;

    @FindBy (xpath = "//mat-option/span[text()=' Guest ']")
    private WebElement userTypeSelect;

    @FindBy(xpath = "//ms-save-button//button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement message;

    @FindBy (xpath="//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    public WebElement searchItemCategotiesName;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindAll(

            {@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-tns-c348-69 ng-star-inserted']")}
    )
    public List<WebElement> namelists;


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



    public void find_And_Click_Element(String elementName) {
//*
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




            //TODO---------------------------------------
                /*
                Item_Categories
                 */
            case "Inventory":
                currentElement = Inventory;
                break;

            case "Inventory_Setup":
                currentElement =  Inventory_Setup;
                break;

            case "Item_Categories":
                currentElement =  Item_Categories;
                break;

            case "userTypeclick":
                currentElement =  userTypeclick;
                break;

            case "userTypeSelect":
                currentElement =  userTypeSelect;
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


    public void find_Element_And_Send_Keys(String elementName, String text) {

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


            case "searchItemCategotiesName":
                currentElement =  searchItemCategotiesName;
                break;

            case "nameInput":
                currentElement =  nameInput;
                break;
      }
        sendKeysElement(currentElement, text);
    }



    public void find_Element_And_Verify_Contains_Text(String TextName, String msg) {

        switch (TextName) {

            case "message":
                currentElement = message;
                break;

            case "Item_Title":
                currentElement = Item_Title;
                break;
      }
        verifyElementContainsText(currentElement, msg);
    }


    public  void edit_And_Delete_Function(String subjectName,String editorDelete) {

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

    public void check_Elements_in_the_Lists(String listName, String text) {

        switch (listName) {

            case "namelists":
                currentList = namelists;
                break;
        }

        for (WebElement n : currentList) {

            Assert.assertTrue(n.getText().contains(text));
        }
    }


}
