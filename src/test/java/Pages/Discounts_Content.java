package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Discounts_Content extends Parent {

    WebElement currentElement;
    List<WebElement> currentList;

    public Discounts_Content()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")

    private WebElement parameters;

    @FindBy(xpath = "(//span[text()='Discounts'])[1]")

    private WebElement Discount;

    //h3[text()='  Discounts ']
    @FindBy(xpath = "(//h3[text()='  Discounts ']")

    public WebElement pagetitle;


    //Todo Discounts
    @FindBy (css = "ms-text-field[formcontrolname='description']>input")
    private WebElement description;

    @FindBy (css = "ms-text-field[formcontrolname='code']>input")
    private WebElement integrationCode;

    @FindBy (css = "ms-text-field[formcontrolname='priority']>input")
    private WebElement priority;

    @FindBy (xpath="//ms-text-field[@placeholder='DISCOUNT.TITLE.DESCRIPTION']//input")
    public WebElement searchDiscount;

//    @FindBy(xpath = "//ms-search-button//button")
//    private WebElement searchButton;



    WebElement myElement;

    public void findAndClickElement(String elementName) {

        switch (elementName) {
            case "setupOne":
                myElement = setupOne;
                break;

            case "parameters":
                myElement = parameters;
                break;

            case "Discount":
                myElement = Discount;
                break;


//            case "searchButton":
//                currentElement = searchButton;
//                break;



        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeys(String elementName, String text) {

        switch (elementName) {

            case "description":
                currentElement = description;
                break;

            case "integrationCode":
                currentElement = integrationCode;
                break;

            case "priority":
                currentElement = priority;
                break;

            case "searchDiscount":
                currentElement = searchDiscount;
                break;

        }

        sendKeysElement(currentElement, text);
    }






}





