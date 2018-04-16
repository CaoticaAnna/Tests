package pro.miniapps.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class PaymentDetailsPage {
    public PaymentDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "cardNum")
    private WebElement cardNum;

    @FindBy(id = "expiryDate")
    private WebElement expDate;

    @FindBy(xpath = "//*[@id=\"cvv\"]")
    private WebElement cardCode;

    @FindBy(xpath = "//*[@id=\"firstNameID\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"lastNameID\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"zipID\"]")
    private WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"billingAddressID\"]")
    private WebElement address;

    @FindBy(xpath = "//*[@id=\"cityID\"]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"stateID\"]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"saveBtn\"]")
    private WebElement saveBtn;

    @FindBy(css = "body > div.ui-pnotify.ui-pnotify-top > div > div.ui-pnotify-text")
    private WebElement topUpConfirm;

    @FindBy(css = "body > div.ui-pnotify.ui-pnotify-top > div > div.ui-pnotify-closer > span")
    private WebElement closeConf;


    public void inputCardNum() {
        WebElement num = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(cardNum));
        Actions actions = new Actions(driver);
        actions.moveToElement(num);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", num);
        num.sendKeys("4222222222222");
        actions.build().perform();
    }

    public void inputCardInfo() {
        expDate.sendKeys("0922");
        cardCode.sendKeys("789");
        firstName.sendKeys("VERONIKA");
        lastName.sendKeys("IVANOVA");
        zipCode.sendKeys("630055");
        address.sendKeys("RUSSIA, NOVOSIBIRSK, MUSY JALILYA ST. 3/1");
        city.sendKeys("NOVOSIBIRSK");
        state.sendKeys("RUSSIA");

    }

    public void saveClick() {
        saveBtn.click();
    }

  public String confirmation() {
        String confirmation = (new WebDriverWait((driver), 500)).until(ExpectedConditions.elementToBeClickable(topUpConfirm)).getText();
        return confirmation;
        }
}





